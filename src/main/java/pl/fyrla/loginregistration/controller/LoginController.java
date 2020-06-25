package pl.fyrla.loginregistration.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.fyrla.loginregistration.config.LoginCredentials;

/**
 * @author Krzysztof
 * @project login-registration
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials loginCredentials) {

    }
}
