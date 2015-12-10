package com.dao;

import java.util.List;

import com.Model.Order;
import com.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImplementation implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void deleteUserByID(int id) {
        userDAO.deleteUserByID(id);
    }

    @Override
    @Transactional
    public List<User> getUser() {
        return userDAO.getUser();
    }

    @Transactional
    public User getUserByID(int id) {
        return userDAO.getUserByID(id);
    }

    @Override
    @Transactional
    public void updateUser(String name, String lastName, String gender, String city, int id) {
        userDAO.updateUser(name, lastName, gender, city, id);
    }

    @Override
    public List<User> searchUser(String searchKey) {
        return userDAO.searchUser(searchKey);
    }

    @Override
    public List<Order> getOrders() {
        return userDAO.getOrders();
    }

}
