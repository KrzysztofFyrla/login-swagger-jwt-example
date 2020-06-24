package pl.fyrla.loginregistration.controller.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Krzysztof
 * @project login-registration
 */
@Getter
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String surname;
}
