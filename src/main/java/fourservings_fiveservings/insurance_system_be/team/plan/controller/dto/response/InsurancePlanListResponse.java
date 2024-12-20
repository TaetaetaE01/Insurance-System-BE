package fourservings_fiveservings.insurance_system_be.team.plan.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.plan.entity.InsurancePlan;
import lombok.Builder;

@Builder
public record InsurancePlanListResponse(
    Long id,
    String title,
    String insurancePlanType,
    String plannerName,
    String description,
    String reviewStatus,
    String fileUrl
) {

    public static InsurancePlanListResponse from(InsurancePlan insurancePlan, String fileUrl) {
        return InsurancePlanListResponse.builder()
            .id(insurancePlan.getId())
            .title(insurancePlan.getTitle())
            .insurancePlanType(insurancePlan.getInsurancePlanType().getName())
            .plannerName(insurancePlan.getPlanner().getName())
            .description(insurancePlan.getDescription())
            .reviewStatus(insurancePlan.getReviewStatus().name())
            .fileUrl(fileUrl)
            .build();
    }
}
