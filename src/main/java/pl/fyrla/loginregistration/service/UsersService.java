package pl.fyrla.loginregistration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fyrla.loginregistration.model.Users;
import pl.fyrla.loginregistration.repository.UsersRepository;

import java.util.List;

/**
 * @author Krzysztof
 * @project login-registration
 */
@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public List<Users> getUsersAll() {
        return usersRepository.findAll();
    }
}
