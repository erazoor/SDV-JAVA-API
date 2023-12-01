package fr.erazor.project.service;

import fr.erazor.project.dto.user.UserUpdateDTO;
import fr.erazor.project.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Optional<List<User>> getUserByUsername(String username);
    Optional<List<User>> getUserByEmail(String email);
    List<User> getAllUsers();
    User updateUser(Long id, UserUpdateDTO userUpdateDTO);
    void deleteUser(Long id);
}
