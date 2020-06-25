package pl.fyrla.loginregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fyrla.loginregistration.model.Users;

/**
 * @author Krzysztof
 * @project login-registration
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
