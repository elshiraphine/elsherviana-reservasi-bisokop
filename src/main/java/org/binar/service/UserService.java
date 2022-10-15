package org.binar.service;

import org.binar.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Users addUser (Users user);
    public List<Users> addUsers (List<Users> users);
    public Optional<Users> getUserById (Long id);
    public List<Users> getAllUsers();
    public void updateUser (Long userId, Users users);
    public void deleteUser (Long userId);
}
