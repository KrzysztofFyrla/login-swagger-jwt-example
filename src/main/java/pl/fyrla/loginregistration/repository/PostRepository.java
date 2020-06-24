package pl.fyrla.loginregistration.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.fyrla.loginregistration.model.Post;

import java.util.List;

/**
 * @author Krzysztof
 * @project login-registration
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("Select p From Post p" +
                " left join fetch p.comments")
    List<Post> findAllPosts(Pageable pageable);

    List<Post> findByUserIdIn(List<Long> ids);
}
