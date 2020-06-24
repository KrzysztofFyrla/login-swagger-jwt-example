package pl.fyrla.loginregistration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.fyrla.loginregistration.model.Comment;
import pl.fyrla.loginregistration.model.Post;
import pl.fyrla.loginregistration.repository.CommentRepository;
import pl.fyrla.loginregistration.repository.PostRepository;

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
public class PostService {

    public static final int PAGE_SIZE = 5;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Post> getPosts(int page, Sort.Direction sort) {
        return postRepository.findAllPosts(
                PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")
                )
        );
    }

    public Optional<Post> getSinglePost(long id) {
        return postRepository.findById(id);
    }

    public List<Post> getPostWithComment(int page, Sort.Direction sort) {
        List<Post> allPosts =  postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")
        ));
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findByPostIdIn(ids);
        allPosts.forEach(post -> post.setComments(exctractComments(comments, post.getId())));
        return allPosts;
    }

    private List<Comment> exctractComments(List<Comment> comments, Long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post editPost(Post post) throws Exception {
        Post postEdit = postRepository.findById(post.getId()).orElseThrow(() -> new Exception("Post not found"));
        postEdit.setTitle(post.getTitle());
        postEdit.setContent(post.getContent());
        return postEdit;
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
