package com.rdba.repository.hibernate;

import com.rdba.repository.ItemRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rdba.model.jpa.item.Item;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Item getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Item item = session.get(Item.class, id);
        return item;
    }

    @Override
    public Item save(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(item);
        return item;
    }

    @Override
    public List<Item> getAllItem() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> cq = builder.createQuery(Item.class);
        Root<Item> root = cq.from(Item.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }
}
