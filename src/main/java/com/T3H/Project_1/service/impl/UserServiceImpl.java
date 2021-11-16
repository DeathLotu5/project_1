package com.T3H.Project_1.service.impl;

import com.T3H.Project_1.entity.User;
import com.T3H.Project_1.model.UserDTO;
import com.T3H.Project_1.repository.UserRepository;
import com.T3H.Project_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRoles(userDTO.getRoles());

        userRepository.addUser(user);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = userRepository.getUserById(userDTO.getId());
        if(user != null) {
            user.setName(userDTO.getName());
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setRoles(userDTO.getRoles());

            userRepository.updateUser(user);
        }
    }

    @Override
    public void deleteUser(int id ) {
        User user = userRepository.getUserById(id);
        if(user != null) userRepository.deleteUser(user);
    }

    @Override
    public UserDTO getUserById(int id) {
        User user = userRepository.getUserById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles());

        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }
}
