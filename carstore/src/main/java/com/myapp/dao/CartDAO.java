package com.myapp.dao;
import com.myapp.entity.Cart;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Collections;
import java.util.List;

public class CartDAO implements CartDAOInterface<Cart, Integer>{
    private final static Logger LOG= Logger.getLogger(CartDAO.class.getName());
    private Session currentSession;
    private Transaction currentTransaction;
    public CartDAO() {
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
    public void persist(Cart entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Cart entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Cart findById(Integer integer) {
        return getCurrentSession().get(Cart.class,integer);
    }

    @Override
    public void delete(Cart entity) {
        getCurrentSession().delete(entity);

    }

    @Override
    public List<Cart> findAll() {
        return (List<Cart>)getCurrentSession().createQuery("FROM Cart").list();
    }

    @Override
    public void deleteAll() {
        getCurrentSession().createQuery("DELETE FROM Cart").executeUpdate();
    }

}
