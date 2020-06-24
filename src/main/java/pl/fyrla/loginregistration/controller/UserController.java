package pl.fyrla.loginregistration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.fyrla.loginregistration.controller.dto.UserDto;
import pl.fyrla.loginregistration.controller.dto.UserDtoMapper;
import pl.fyrla.loginregistration.model.User;
import pl.fyrla.loginregistration.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * @author Krzysztof
 * @project login-registration
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUserAll(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return UserDtoMapper.mapToUserDtos(userService.getUserAll(pageNumber, sortDirection));
    }

    @GetMapping("/users/posts")
    public List<User> getUserWitchPost(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return userService.getUserWithPost(pageNumber, sortDirection);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserSingle(@PathVariable Long id) {
        return userService.getUserSingle(id);
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) throws Exception {
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
