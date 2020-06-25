package pl.fyrla.loginregistration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fyrla.loginregistration.model.Users;
import pl.fyrla.loginregistration.service.UsersService;

import java.util.List;

/**
 * @author Krzysztof
 * @project login-registration
 */
@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/testowo")
    public List<Users> getUsersAll() {
        return usersService.getUsersAll();
    }
}
