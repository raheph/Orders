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

    private  static AtomicLong id = new AtomicLong(1);
    public  static void getOrders1(){
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Items items1 = new Items ("S01", "shose", new BigDecimal(40.50));
//        Items items2 = new Items ("S02", "shose", new BigDecimal(40.50));
//        Items items3 = new Items ("S03", "shose", new BigDecimal(40.50));
//
//        OrderItems orderItems1 = new OrderItems("order1", items1, 2);
//        OrderItems orderItems2 = new OrderItems("order2", items2, 2);
//        OrderItems orderItems3 = new OrderItems("order3", items3, 2);
//
//        List<OrderItems> OrderItems = new ArrayList<>();
//        OrderItems.add(orderItems1);
//        OrderItems.add(orderItems2);
//        OrderItems.add(orderItems3);
//
//        Orders orders = new Orders("Order001", new Date(), "Rahel E", OrderItems);
//        session.persist(items1);
//        session.persist(items2);
//        session.persist(items3);
//        session.persist(orderItems1);
//        session.persist(orders);
//
//        session.getTransaction().commit();
//        logger.info("commited ... ");
//        session.close();
//     //  getOrders2("Order001");
//        logger.warn("You good :)");
    }

    public static List<OrderItems>  getOrders(String orderId){
     //   getOrders1();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String orders = "From Orders where OrderId= " + "'" + orderId + "'";
        Query query = session.createQuery(orders);
        List<Orders> ordersList = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return ordersList.get(0).getOrderItems();
    }
}
