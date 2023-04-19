package fr.thomas.agendauml.service.impl;

import fr.thomas.agendauml.exception.CustomException;
import fr.thomas.agendauml.model.User;
import fr.thomas.agendauml.model.dto.UserDTO;
import fr.thomas.agendauml.repository.UserRepository;
import fr.thomas.agendauml.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new CustomException("Utilisateur inexistant !"));
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = new User(userDTO.getLogin(), userDTO.getPassword());
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long userId, UserDTO userDTO) {
        User user = this.getUser(userId);
        user.setLogin((userDTO.getLogin() != null) ? userDTO.getLogin() : user.getLogin());
        user.setPassword((userDTO.getPassword() != null) ? userDTO.getPassword() : user.getPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
