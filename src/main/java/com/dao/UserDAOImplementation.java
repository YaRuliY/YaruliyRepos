package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.Model.Order;
import com.Model.User;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
public class UserDAOImplementation implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(UserDAOImplementation.class);

    @Override
    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void deleteUserByID(int id) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("delete from user where user_id = :ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<User> getUser() {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM user").list();
    }

    @Override
    @Transactional
    public User getUserByID(int user_id) {
        User temp = (User) sessionFactory.getCurrentSession().load(User.class, user_id);
        Hibernate.initialize(temp);
        return temp;
    }

    @Override
    @Transactional
    public void updateUser(String name, String lastName, String gender, String city, int id) {
        Session session = sessionFactory.getCurrentSession();
        User temp = (User) session.load(User.class, id);
        Hibernate.initialize(temp);
        temp.setFirstName(name);
        temp.setLastName(lastName);
        temp.setGender(gender);
        temp.setCity(city);
        session.update(temp);
    }

    @Override
    @Transactional
    public List<User> searchUser(String searchKey) {
        List<Integer> id = sessionFactory.getCurrentSession().createSQLQuery("SELECT user_id FROM user").list();
        List<User> users = new ArrayList<User>();
        for (int i=0;i<id.size();i++){
            User temp = (User) sessionFactory.getCurrentSession().load(User.class, id.get(i));
            Hibernate.initialize(temp);
            users.add(temp);
        }
        List findUsers = new ArrayList<User>();
        for (int i=0;i<users.size();i++){
            if (users.get(i).search(searchKey)) findUsers.add(users.get(i));
        }
        return findUsers;
    }

    @Override
    @Transactional
    public List<Order> getOrders() {
        List<Integer> idList = sessionFactory.getCurrentSession().createSQLQuery("SELECT order_id FROM orderu").list();
        List<Order> orders = new ArrayList<Order>();
        for (int i=0;i<idList.size();i++){
            Order temp = (Order) sessionFactory.getCurrentSession().load(Order.class, idList.get(i));
            Hibernate.initialize(temp);
            orders.add(temp);
        }

        /*List<Integer> idListProduct = sessionFactory.getCurrentSession().createSQLQuery("SELECT order_id FROM orderproducts").list();
        List<OrderProducts> orderProducts = new ArrayList<OrderProducts>();
        for (int i=0;i<idListProduct.size();i++){
            OrderProducts temp = (OrderProducts) sessionFactory.getCurrentSession().load(OrderProducts.class, idListProduct.get(i));
            Hibernate.initialize(temp);
            orderProducts.add(temp);
        }
        for (int i=0;i<orderProducts.size();i++){
            logger.info("[][][][][][] Order: "+orderProducts.get(i).getOrder_id()+" ProductID: "+orderProducts.get(i).getProduct_id());
        }*/

        /*List<Integer> IdOfAllProducts = sessionFactory.getCurrentSession().createSQLQuery("SELECT product_id FROM product").list();
        List<Product> allProducts = new ArrayList<Product>();
        for (int i=0;i< IdOfAllProducts.size();i++){
            Product temp = (Product) sessionFactory.getCurrentSession().load(OrderProducts.class, IdOfAllProducts.get(i));
            Hibernate.initialize(temp);
            allProducts.add(temp);
        }

        List<Integer> order_id_from_order_id =
                sessionFactory.getCurrentSession().createSQLQuery("SELECT order_id FROM orderproducts").list();
        List<Integer> product_id_from_order_id =
                sessionFactory.getCurrentSession().createSQLQuery("SELECT product_id FROM orderproducts").list();

        for (int i=0;i<orders.size();i++){
            if (order_id_from_order_id.contains(orders.get(i).getOrder_id())) {
                Product temp = new Product();
                for (int j=0;j<allProducts.size();j++){
                    if (allProducts.get(j).getProduct_id() == product_id_from_order_id.get(i))
                        temp = allProducts.get(j);
                    break;
                }
                orders.get(i).setProducts("Name: "+temp.getName()+"Type: "+temp.getType());
            }
        }
*/
        return orders;
    }
}
