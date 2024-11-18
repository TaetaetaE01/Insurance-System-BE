package fourservings_fiveservings.insurance_system_be.team.contract.controller.dto;

import fourservings_fiveservings.insurance_system_be.team.contract.entity.car.CarContract;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import fourservings_fiveservings.insurance_system_be.team.product.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.user.entity.User;

public record ContractApplyRequestDto(

) {

    public static Contract toEntity(User appliedCustomer, Product product) {
        return CarContract.builder()
            .subscriber(appliedCustomer)
            .product(product)
            .approveStatus(ApproveStatus.PENDING)
            .build();
    }
}