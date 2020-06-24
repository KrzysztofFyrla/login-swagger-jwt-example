package pl.fyrla.loginregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fyrla.loginregistration.model.Comment;

import java.util.List;

/**
 * @author Krzysztof
 * @project login-registration
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostIdIn(List<Long> ids);
}
