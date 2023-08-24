package com.jeion.Spring3_1.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jeion.Spring3_1.web.dao.UserDao;
import com.jeion.Spring3_1.web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   UserServiceImp (UserDao userDao) { this.userDao = userDao;}

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public void delete(int id) { userDao.delete(id);}

   @Override
   public User findUser(int id) {
      return userDao.findUser(id);
   }

   @Transactional
   @Override
   public void updateUser(User user) {
      userDao.updateUser(user);
   }
}
