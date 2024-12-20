package fourservings_fiveservings.insurance_system_be.team.contract.car.controller;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.constant.SuccessType;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import fourservings_fiveservings.insurance_system_be.team.contract.car.api.CarContractApi;
import fourservings_fiveservings.insurance_system_be.team.contract.car.controller.dto.request.CreateCarContractRequestDto;
import fourservings_fiveservings.insurance_system_be.team.contract.car.service.CarContractService;
import fourservings_fiveservings.insurance_system_be.team.contract.common.controller.dto.response.CarContractDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarContractController implements CarContractApi {

    private final CarContractService carContractService;

    public ApiResponse<?> createContract(CustomUserDetails customUserDetails,
                                         Long insuranceId,
                                         CreateCarContractRequestDto createCarContractRequestDto) {
        carContractService.createContract(customUserDetails.getCustom(), insuranceId,
                createCarContractRequestDto);
        return ApiResponse.success(SuccessType.CREATED);
    }


    public ApiResponse<?> getContractDetail(Long contractId,
                                            CustomUserDetails customUserDetails) {
        CarContractDetailResponseDto carContractDetailDto = carContractService.getContractDetail(
                contractId, customUserDetails);
        return ApiResponse.success(SuccessType.SUCCESS, carContractDetailDto);
    }
}
