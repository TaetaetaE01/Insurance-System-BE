package fourservings_fiveservings.insurance_system_be.team.contract.entity;

import fourservings_fiveservings.insurance_system_be.common.entity.BaseEntity;
import fourservings_fiveservings.insurance_system_be.domain.insurance.ApproveStatus;
import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import fourservings_fiveservings.insurance_system_be.team.product.entity.Product;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contract extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    @Embedded
    private InsuranceApplication insuranceApplication;

    @Enumerated(EnumType.STRING)
    private ApproveStatus approveStatus;

    @Builder
    public Contract(User user, Product product, ApproveStatus approveStatus) {
        this.user = user;
        this.product = product;
        this.approveStatus = approveStatus;
    }

    public static Contract fromUnApproveContract(User appliedCustomer, Product product) {
        return Contract.builder()
            .user(appliedCustomer)
            .product(product)
            .approveStatus(ApproveStatus.UN_APPROVE)
            .build();
    }

    public void setInsurance(InsuranceApplication insuranceApplication) {
        this.insuranceApplication = insuranceApplication;
    }

    //    @Override
//    public String toString() {
//        return "contract ID = " + id + "\n" +
//            "customer Name = " + customerName + '\n' +
//            "insurance ID = " + insuranceApplication.getInsuranceApplicationID() + '\n' +
//            "insurance Type = " + insuranceApplication.getInsurance().getInsuranceType() + '\n' +
//            "managerName = " + managerName;
//    }
}