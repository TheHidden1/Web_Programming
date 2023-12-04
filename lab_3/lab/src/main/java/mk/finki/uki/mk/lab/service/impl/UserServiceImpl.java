package mk.finki.uki.mk.lab.service.impl;

import mk.finki.uki.mk.lab.model.User;
import mk.finki.uki.mk.lab.model.exceptions.UserNotFoundException;
import mk.finki.uki.mk.lab.repository.jpa.UserRepository;
import mk.finki.uki.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }
}
