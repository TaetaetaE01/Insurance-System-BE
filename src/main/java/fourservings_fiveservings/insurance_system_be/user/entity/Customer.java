package fourservings_fiveservings.insurance_system_be.user.entity;

import fourservings_fiveservings.insurance_system_be.user.customer.ContractStatus;
import fourservings_fiveservings.insurance_system_be.user.UserType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {

    private ContractStatus contractStatus;

    @Builder
    private Customer(String loginId, String password, String email, String phoneNumber, Address address,
                     String name, String birthDay, UserType userType, ContractStatus contractStatus) {
        super(loginId, password, email, phoneNumber, address, name, birthDay, UserType.CUSTOMER);
        this.contractStatus = ContractStatus.NONE;
    }
}