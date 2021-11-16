package com.T3H.Project_1.repository;

import com.T3H.Project_1.entity.User;

import java.util.List;

public interface UserRepository {
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User getUserById(int id);
    public List<User> getAllUser();
    public User getByUsername(String username);
}
