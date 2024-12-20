package fourservings_fiveservings.insurance_system_be.user.repository;

import fourservings_fiveservings.insurance_system_be.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
