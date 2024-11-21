package fourservings_fiveservings.insurance_system_be.team.contract.service.implement;

import fourservings_fiveservings.insurance_system_be.common.exception.BusinessException;
import fourservings_fiveservings.insurance_system_be.team.contract.entity.common.Contract;
import fourservings_fiveservings.insurance_system_be.team.contract.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static fourservings_fiveservings.insurance_system_be.common.exception.constant.ErrorType.NO_EXIST_CONTRACT;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContractFinder {

    private final ContractRepository contractRepository;

    public Contract findById(Long contractId) {
        return contractRepository.findById(contractId)
                .orElseThrow(() -> new BusinessException(NO_EXIST_CONTRACT));
    }
}
