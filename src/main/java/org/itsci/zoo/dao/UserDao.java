package org.itsci.zoo.dao;

import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void saveUser(User user);
    User getUser(Long id);
    void deleteUser(Long id);
    User findByUsername(String username);
}