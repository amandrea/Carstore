package com.myapp.dao;

import com.myapp.entity.UserType;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class UserTypeDAO implements UserTypeDAOInterface<UserType, Integer> {
    private final static Logger LOG = Logger.getLogger(UserTypeDAO.class.getName());
    private Session currentSession;
    private Transaction currentTransaction;

    public UserTypeDAO() {
//We dont need to initialize anything
    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        LOG.info("S-a deschis sesiunea");
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(UserType entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(UserType entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public UserType findById(Integer integer) {
        return getCurrentSession().get(UserType.class, integer);
    }

    @Override
    public void delete(UserType entity) {
        getCurrentSession().delete(entity);

    }

    @Override
    public List<UserType> findAll() {
        return (List<UserType>) getCurrentSession().createQuery("FROM UserType").list();
    }

    @Override
    public void deleteAll() {
        getCurrentSession().createQuery("DELETE FROM UserType").executeUpdate();
    }

}