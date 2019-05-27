package com.example.demo.Repositories;

import com.example.demo.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class UserRepository implements UserRepositoryI {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <S extends User> S save(S s) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save( s );
        session.getTransaction().commit();
        session.close();

        return s;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {

        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        // Open a session
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.from(User.class);

        ArrayList<User> contacts = (ArrayList<User>) session.createQuery(criteria).getResultList();

        // Close the session
        session.close();

        return contacts;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.createSQLQuery("truncate table users").executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public void deleteByEmail(final String email){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("delete User u where u.email = :EMAIL");
        query.setParameter("EMAIL", email);
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public Optional<User> findByEmail(String mail) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User u where u.email = :email ");
        query.setParameter("email", mail);

        return Optional.ofNullable( (User)query.getSingleResult() );
    }
}