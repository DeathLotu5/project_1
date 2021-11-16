package com.T3H.Project_1.service;

import com.T3H.Project_1.entity.User;
import com.T3H.Project_1.model.UserDTO;

import java.util.List;

public interface UserService {
    public void addUser(UserDTO userDTO);
    public void updateUser(UserDTO userDTO);
    public void deleteUser(int id);
    public UserDTO getUserById(int id);
    public List<UserDTO> getAllUser();
}
