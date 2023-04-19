package fr.thomas.agendauml.service;

import fr.thomas.agendauml.model.User;
import fr.thomas.agendauml.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(Long userId);

    void createUser(UserDTO userDTO);

    void updateUser(Long userId, UserDTO userDTO);

    void deleteUser(Long userId);
}
