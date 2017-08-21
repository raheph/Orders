package com.DB;

import com.model.Items;
import com.model.OrderItems;
import com.model.Orders;
import com.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by ephrar1 on 8/14/2017.
 */
public class DataBaseConnection {
    private static final Logger logger = Logger.getLogger(DataBaseConnection.class);

    public static List<OrderItems>  getOrders(String orderId){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String orders = "From Orders where OrderId= " + "'" + orderId + "'";
        Query query = session.createQuery(orders);
        List<Orders> ordersList = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return ordersList == null ? null :ordersList.get(0).getOrderItems();
    }
}
