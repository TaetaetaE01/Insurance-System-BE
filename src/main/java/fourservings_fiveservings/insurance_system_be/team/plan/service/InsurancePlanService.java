package fourservings_fiveservings.insurance_system_be.team.plan.service;

import fourservings_fiveservings.insurance_system_be.file.service.S3Service;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.request.CreatePlanRequestDto;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.request.ReviewPlanRequestDto;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.response.InsurancePlanListResponse;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.response.InsurancePlanResponse;
import fourservings_fiveservings.insurance_system_be.team.plan.entity.InsurancePlan;
import fourservings_fiveservings.insurance_system_be.team.plan.service.implement.InsurancePlanFinder;
import fourservings_fiveservings.insurance_system_be.team.plan.service.implement.InsurancePlanSaver;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InsurancePlanService {

    private final InsurancePlanFinder insurancePlanFinder;
    private final InsurancePlanSaver insurancePlanSaver;
    private final S3Service s3Service;

    @Transactional
    public void createPlan(Worker planner, CreatePlanRequestDto requestDto) {
        String uploadedFileName = s3Service.uploadFile(requestDto.file());
        InsurancePlan insurancePlan = requestDto.toEntity(planner, uploadedFileName);
        insurancePlanSaver.save(insurancePlan);
    }

    public List<InsurancePlanListResponse> getAll() {
        List<InsurancePlan> insurancePlans = insurancePlanFinder.getAll();
        return insurancePlans.stream()
            .map(InsurancePlanListResponse::from)
            .toList();
    }

    @Transactional
    public void reviewPlan(
        Worker reviewer,
        Long planId,
        ReviewPlanRequestDto requestDto
    ) {
        InsurancePlan insurancePlan = insurancePlanFinder.findById(planId);
        insurancePlan.updateReview(reviewer, requestDto.getReviewStatus(), requestDto.comments());
    }

    public InsurancePlanResponse getInsurancePlan(Long planId) {
        InsurancePlan insurancePlan = insurancePlanFinder.findById(planId);
        String fileUrl = s3Service.getFileUrl(insurancePlan.getFileName());
        return InsurancePlanResponse.of(insurancePlan, fileUrl);
    }
}