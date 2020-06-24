package pl.fyrla.loginregistration.controller.dto;

import pl.fyrla.loginregistration.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Krzysztof
 * @project login-registration
 */
public class UserDtoMapper {

    public UserDtoMapper() {
    }

    public static List<UserDto> mapToUserDtos(List<User> users) {
        return users.stream()
                .map(user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }
}
