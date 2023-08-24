package com.jeion.Spring3_1.web.dao;

import com.jeion.Spring3_1.web.model.User;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   void delete(int id);
   User findUser(int id);
    void updateUser(User user);
}
