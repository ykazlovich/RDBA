package com.rdba.repository.hibernate;

import com.rdba.repository.ClientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rdba.model.jpa.client.Client;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Client get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, id);
    }

    @Override
    public List<Client> findByNameOrPhone(String text) {
        String searchPattern = "%" + text + "%";
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Client> cq = cb.createQuery(Client.class);

        Root<Client> clientRoot = cq.from(Client.class);
        cq
                .select(clientRoot)

                .where(cb
                        .like(clientRoot.get("name"), searchPattern))
                .where(cb
                        .like(clientRoot.get("phone"), searchPattern));
        return session.createQuery(cq).getResultList();
    }

    @Override
    public List<Client> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = cb.createQuery(Client.class);
        Root<Client> clientRoot = criteriaQuery.from(Client.class);
        criteriaQuery.select(clientRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Client save(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(client);
        return client;

    }
}
