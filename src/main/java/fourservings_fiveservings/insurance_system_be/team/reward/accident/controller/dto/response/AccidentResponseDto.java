package fourservings_fiveservings.insurance_system_be.team.reward.accident.controller.dto.response;

import fourservings_fiveservings.insurance_system_be.team.reward.accident.entity.Accident;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record AccidentResponseDto(
        Long id,
        String title,
        LocalDateTime accidentDate,
        String description,
        String location,
        BigDecimal damageAmount,
        String fileUrl,
        String accidentType,
        String customerName,
        String liabilityStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static AccidentResponseDto from(Accident accident, String fileUrl) {
        return AccidentResponseDto.builder()
                .id(accident.getId())
                .title(accident.getTitle())
                .accidentDate(accident.getAccidentDate())
                .description(accident.getDescription())
                .location(accident.getLocation())
                .damageAmount(accident.getDamageAmount())
                .fileUrl(fileUrl)
                .accidentType(accident.getAccidentType().getName())
                .customerName(accident.getCustomer().getName())
                .liabilityStatus(accident.getLiabilityStatus().getDescription())
                .createdAt(accident.getCreatedAt())
                .updatedAt(accident.getUpdatedAt())
                .build();
    }
}
