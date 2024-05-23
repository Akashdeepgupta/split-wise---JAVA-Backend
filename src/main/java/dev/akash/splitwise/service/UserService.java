package dev.akash.splitwise.service;

import dev.akash.splitwise.model.User;

public interface UserService {
    User SignUp(String name, String email, String password);

}
