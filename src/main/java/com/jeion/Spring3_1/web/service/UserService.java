package com.jeion.Spring3_1.web.service;

import com.jeion.Spring3_1.web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void delete(int id);

    User findUser(int id);
    public void updateUser(User user);
}
