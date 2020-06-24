package pl.fyrla.loginregistration.controller.dto;

import pl.fyrla.loginregistration.model.Post;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Krzysztof
 * @project login-registration
 */
public class PostDtoMapper {

    private PostDtoMapper() {
    }

    public static List<PostDto> mapToPostDtos(List<Post> posts) {
        return posts.stream()
                .map(post -> mapToPostDto(post))
                .collect(Collectors.toList());
    }

    private static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
