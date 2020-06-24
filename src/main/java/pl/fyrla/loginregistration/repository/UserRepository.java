package pl.fyrla.loginregistration.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.fyrla.loginregistration.model.User;

import java.util.List;

/**
 * @author Krzysztof
 * @project login-registration
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select p From User p" +
            " left join fetch p.posts")
    List<User> findAllUsers(Pageable pageable);
}
