package fourservings_fiveservings.insurance_system_be.team.plan.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.plan.api.InsurancePlanApi;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.request.CreatePlanRequestDto;
import fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.response.InsurancePlanListResponse;
import fourservings_fiveservings.insurance_system_be.team.plan.service.InsurancePlanService;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InsurancePlanController implements InsurancePlanApi {

    private final InsurancePlanService insurancePlanService;

    @Override
    public ApiResponse<?> createPlan(CustomUserDetails customUserDetails,
                                        CreatePlanRequestDto createPlanRequestDto) {
        Worker planner = customUserDetails.getWorker();
        insurancePlanService.createPlan(planner, createPlanRequestDto);
        return ApiResponse.success(SuccessType.SUCCESS);
    }

    @Override
    public ApiResponse<List<InsurancePlanListResponse>> getAllInsurancePlans() {
        List<InsurancePlanListResponse> responses = insurancePlanService.getAllInsurancePlans();
        return ApiResponse.success(SuccessType.SUCCESS, responses);
    }

    @Override
    public ApiResponse<?> approveProduct(CustomUserDetails customUserDetailsService,
                                         Long productId) {
        Worker approveWorker = customUserDetailsService.getWorker();
//        insurancePlanService.approveProduct(approveWorker, productId);
        return ApiResponse.success(SuccessType.SUCCESS);
    }
}
