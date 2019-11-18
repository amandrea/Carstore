package com.myapp.dao;

import com.myapp.entity.Car;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class CarDAO implements CarDAOInterface<Car, Integer>{
    private final static Logger LOG= Logger.getLogger(CarDAO.class.getName());
private Session currentSession;
private Transaction currentTransaction;

    public CarDAO() {
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
    public void persist(Car entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Car entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Car findById(Integer integer) {
       return getCurrentSession().get(Car.class,integer);
    }

    @Override
    public void delete(Car entity) {
        getCurrentSession().delete(entity);

    }

    @Override
    public List<Car> findAll() {
        return (List<Car>)getCurrentSession().createQuery("FROM Car").list();
    }

    @Override
    public void deleteAll() {
        getCurrentSession().createQuery("DELETE FROM Car").executeUpdate();
    }
}
