package mk.finki.uki.mk.lab.service;

import mk.finki.uki.mk.lab.model.User;

import java.util.Optional;

public interface UserService {
    User findByUsername(String username);
}
