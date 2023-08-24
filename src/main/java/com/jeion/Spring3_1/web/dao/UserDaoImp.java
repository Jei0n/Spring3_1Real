package com.jeion.Spring3_1.web.dao;

import com.jeion.Spring3_1.web.model.User;

import java.util.List;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImp implements UserDao {
   @PersistenceContext
   EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return entityManager.createQuery("SELECT u FROM User u", User.class)
              .getResultList();
   }

   @Override
   public void delete(int id) {
      User user = findUser(id);
      if(user == null)
         throw new NullPointerException("Wrong user");
      entityManager.remove(user);
   }

   @Override
   public User findUser(int id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }
}
