package fourservings_fiveservings.insurance_system_be.auth.service;

import fourservings_fiveservings.insurance_system_be.auth.dto.request.SignUpRequest;
import fourservings_fiveservings.insurance_system_be.domain.user.repository.UserRepository;
import fourservings_fiveservings.insurance_system_be.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository<User> userRepository;

    @Transactional
    public void signUp(SignUpRequest signUpRequest) {
        String encodedPassword = "12asdfdsiwyef983e1";
        userRepository.save(signUpRequest.toEntity(encodedPassword));
    }
}
