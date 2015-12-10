package com.dao;

import com.Model.Order;
import com.Model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUserByID(int id);
    List<User> getUser();
    User getUserByID(int id);
    void updateUser(String name, String lastName, String gender, String city, int id);
    List<User> searchUser(String searchKey);
    List<Order> getOrders();
}
