package fourservings_fiveservings.insurance_system_be.team.reward.claim.controller.dto.request;

import fourservings_fiveservings.insurance_system_be.team.reward.accident.entity.Accident;
import fourservings_fiveservings.insurance_system_be.team.reward.claim.entity.Claim;
import fourservings_fiveservings.insurance_system_be.user.entity.Worker;
import java.math.BigDecimal;

public record CreateClaimRequestDto(
    BigDecimal paymentAmount,
    String comments
) {

    public Claim toEntity(Worker worker, Accident accident) {
        return Claim.builder()
            .paymentAmount(paymentAmount)
            .comments(comments)
            .accident(accident)
            .worker(worker)
            .build();
    }
}
