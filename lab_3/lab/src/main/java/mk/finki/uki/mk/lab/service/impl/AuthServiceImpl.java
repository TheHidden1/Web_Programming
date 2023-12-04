package mk.finki.uki.mk.lab.service.impl;

import mk.finki.uki.mk.lab.model.User;
import mk.finki.uki.mk.lab.model.exceptions.InvalidCredentialsException;
import mk.finki.uki.mk.lab.repository.jpa.UserRepository;
import mk.finki.uki.mk.lab.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidCredentialsException::new);
    }
}
