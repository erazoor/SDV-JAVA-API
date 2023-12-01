package fr.erazor.project.service;

import fr.erazor.project.dto.user.UserUpdateDTO;
import fr.erazor.project.util.Validation;
import fr.erazor.project.model.User;
import fr.erazor.project.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if (!Validation.isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!Validation.isValidPassword(user.getPassword())) {
            throw new IllegalArgumentException("Invalid password format");
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        if (userUpdateDTO.getUsername() != null) {
            user.setUsername(userUpdateDTO.getUsername());
        }
        if (userUpdateDTO.getEmail() != null) {
            user.setEmail(userUpdateDTO.getEmail());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public Optional<List<User>> getUserByUsername(String username) {
        List<User> users = userRepository.findByUsername(username);
        return users.isEmpty() ? Optional.empty() : Optional.of(users);
    }

    @Override
    public Optional<List<User>> getUserByEmail(String email) {
        List<User> users = userRepository.findByUsername(email);
        return users.isEmpty() ? Optional.empty() : Optional.of(users);
    }
}
