package pl.fyrla.loginregistration.controller.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Krzysztof
 * @project login-registration
 */
@Getter
@Builder
public class PostDto {

    private Long id;
    private String title;
    private String content;
}
