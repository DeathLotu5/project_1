package com.T3H.Project_1.repository.impl;

import com.T3H.Project_1.entity.User;
import com.T3H.Project_1.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUser() {
        String jql = "SELECT u FROM User u";
        return entityManager.createQuery(jql, User.class).getResultList();
    }

    @Override
    public User getByUsername(String username) {
        String jql = "SELECT u FROM User u WHERE u.username = ?1";
        return entityManager.createQuery(jql, User.class).setParameter(1, username).getSingleResult();
    }


}
