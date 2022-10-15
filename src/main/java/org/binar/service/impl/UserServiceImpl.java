package org.binar.service.impl;

import org.binar.model.Users;
import org.binar.repository.UserRepository;
import org.binar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> addUsers(List<Users> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(Long userId, Users user) {
        Users userById = userRepository.findById(userId).orElseThrow();
        userById.setUser_email(user.getUser_email());
        userById.setUser_password(user.getUser_password());
        userById.setUser_name(user.getUser_name());
        userById.setUser_phone(user.getUser_phone());
        userRepository.save(userById);
    }

    @Override
    public void deleteUser(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
