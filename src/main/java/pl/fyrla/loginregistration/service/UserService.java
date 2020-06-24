package pl.fyrla.loginregistration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.fyrla.loginregistration.model.Post;
import pl.fyrla.loginregistration.model.User;
import pl.fyrla.loginregistration.repository.PostRepository;
import pl.fyrla.loginregistration.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Krzysztof
 * @project login-registration
 */
@Service
@RequiredArgsConstructor
public class UserService {

    public static final int PAGE_SIZE = 5;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<User> getUserAll(int page, Sort.Direction sort) {
        return userRepository.findAllUsers(
                PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")
        ));
    }

    public List<User> getUserWithPost(int page, Sort.Direction sort) {
        List<User> allUsers = userRepository.findAllUsers(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")
        ));

        List<Long> ids = allUsers.stream()
                .map(User::getId)
                .collect(Collectors.toList());

        List<Post> posts = postRepository.findByUserIdIn(ids);
        allUsers.forEach(user -> user.setPosts(exctractPosts(posts, user.getId())));
        return allUsers;
    }

    private List<Post> exctractPosts(List<Post> posts, Long id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .collect(Collectors.toList());
    }

    public Optional<User> getUserSingle(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) throws Exception {
        User userUpdate = userRepository.findById(user.getId()).orElseThrow(() -> new Exception("User not found"));
        userUpdate.setName(user.getName());
        userUpdate.setSurname(user.getSurname());
        return userUpdate;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
