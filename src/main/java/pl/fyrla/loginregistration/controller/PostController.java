package pl.fyrla.loginregistration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.fyrla.loginregistration.controller.dto.PostDto;
import pl.fyrla.loginregistration.controller.dto.PostDtoMapper;
import pl.fyrla.loginregistration.model.Post;
import pl.fyrla.loginregistration.service.PostService;

import java.util.List;
import java.util.Optional;

/**
 * @author Krzysztof
 * @project login-registration
 */
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPost(@RequestParam(required = false) Integer page, Sort.Direction sort,
                                 @AuthenticationPrincipal UsernamePasswordAuthenticationToken user) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return PostDtoMapper.mapToPostDtos(postService.getPosts(pageNumber, sortDirection ));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostWitchComment(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return postService.getPostWithComment(pageNumber, sortDirection);
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getSinglePost(@PathVariable Long id) {
        return postService.getSinglePost(id);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post) throws Exception {
        return postService.editPost(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(Long id) {

        postService.deletePost(id);
    }
}
