package com.myapp.dao;
import com.myapp.entity.Category;
import com.myapp.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Collections;
import java.util.List;
public class CategoryDAO implements CategoryDAOInterface<Category, Integer>{
    private final static Logger LOG= Logger.getLogger(CategoryDAO.class.getName());
    private Session currentSession;
    private Transaction currentTransaction;
    public CategoryDAO() {
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
    public void persist(Category entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Category entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Category findById(Integer integer) {
        return getCurrentSession().get(Category.class,integer);
    }

    @Override
    public void delete(Category entity) {
        getCurrentSession().delete(entity);

    }

    @Override
    public List<Category> findAll() {
        return (List<Category>)getCurrentSession().createQuery("FROM Category").list();
    }

    @Override
    public void deleteAll() {
        getCurrentSession().createQuery("DELETE FROM Category").executeUpdate();
    }

}