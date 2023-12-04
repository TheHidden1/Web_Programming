package mk.finki.uki.mk.lab.service;

import mk.finki.uki.mk.lab.model.User;

public interface AuthService {
    User login(String username, String password);
}
