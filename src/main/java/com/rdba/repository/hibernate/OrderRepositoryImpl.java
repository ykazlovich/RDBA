package com.rdba.repository.hibernate;

import com.rdba.model.jpa.order.Order;
import com.rdba.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
@EnableTransactionManagement
public class OrderRepositoryImpl implements OrderRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Order getOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, orderId);
        return order;
    }

    @Transactional
    @Override
    public Order saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        if (order.isNew()) {
            session.persist(order);
        } else {
            session.merge(order);
        }
        return order;
    }

    @Override
    @Transactional
    public void deleteOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        session.delete(order);
        t.commit();
        session.close();
    }

   @Override
    public List<Order> getAllOrder() {
        Session session = sessionFactory.getCurrentSession();
        //String queryName = "Order.getAll";
        List<Order> list = session
                .createNamedQuery(Order.getAllOrder, Order.class)
                .getResultList();
        return list;
        // N+1 problem...
//        List<Order> list = session.createQuery("from Order").getResultList();
//        return list;
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
//        Root<Order> root = cq.from(Order.class);
//
//        cq.select(root).orderBy(cb.desc(root.get("id")));
//        return session.createQuery(cq).getResultList();
    }
}
