package org.vasyapupkin.DAO;

import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.vasyapupkin.model.Parts;

import java.util.List;

@Repository
public class PartsDAOImpl implements PartsDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Parts> findAllByRelevanceAndPages(int startNumber, int total, boolean relevance) {
        Session session = sessionFactory.getCurrentSession();
        String relevanceString;
        if (relevance)
            relevanceString = "true";
        else
            relevanceString = "false";
        Query query = session.createQuery("FROM Parts WHERE relevance=" + relevanceString);
        query.setFirstResult(startNumber);
        query.setMaxResults(total);
        return query.list();
    }

    @Override
    public int count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT MIN(number) FROM Parts WHERE relevance=true");
        try {
            return (Integer) query.uniqueResult();
        } catch (NonUniqueResultException e) {
            return -1;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Parts> findAllByPages(int startNumber, int total) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Parts");
        query.setFirstResult(startNumber);
        query.setMaxResults(total);
        return query.list();
    }

    @Override
    public Parts findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Parts) session.load(Parts.class, id);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Parts parts = (Parts) session.load(Parts.class, id);
        if (parts != null)
            session.delete(parts);
    }

    @Override
    public void update(Parts parts) {
        Session session = sessionFactory.getCurrentSession();
        session.update(parts);
    }

    @Override
    public void add(Parts parts) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT id FROM Parts WHERE name='" + parts.getName() + "'");
        int id = 0;
        try {
            id = (Integer) query.uniqueResult();
        } catch (NonUniqueResultException | NullPointerException e) {
            e.printStackTrace();
        }
        if (id != 0) {
            Parts oldPart = (Parts) session.load(Parts.class, id);
            parts.setId(oldPart.getId());
            parts.setNumber(parts.getNumber() + oldPart.getNumber());
            session.delete(oldPart);
        }
        session.persist(parts);
    }

    @Override
    public Parts findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("from Parts p where p.name = :name");
        query.setParameter("name", name);
        Parts part = null;
        try {
            part = (Parts) query.uniqueResult();
        } catch (NonUniqueResultException e) {
            System.out.println("There are more than one object with a name: \"" + name + "\"");
        }
        return part;
    }
}
