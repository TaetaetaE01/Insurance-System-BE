package fourservings_fiveservings.insurance_system_be.user.auth;

import fourservings_fiveservings.insurance_system_be.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository<User> userRepository;

    @Transactional
    public void signUp(SignUpRequestDto signUpRequestDto) {
        String encodedPassword = "12asdfdsiwyef983e1";
        userRepository.save(signUpRequestDto.toEntity(encodedPassword));
    }
}
