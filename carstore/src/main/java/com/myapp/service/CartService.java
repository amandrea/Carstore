package com.myapp.service;
import com.myapp.dao.CartDAO;
import com.myapp.entity.Cart;
import org.apache.log4j.Logger;

public class CartService {
    private static CartDAO cartDAO;
    private final static Logger LOG= Logger.getLogger(CartService.class.getName());

    public CartService() {
        cartDAO =new CartDAO();
    }

    public void persist(Cart entity) {
        cartDAO.openCurrentSessionwithTransaction();
        cartDAO.persist(entity);
        cartDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat"+ entity.toString());
    }
    public void delete(Cart entity)
    {
        cartDAO.openCurrentSessionwithTransaction();
        cartDAO.delete(entity);
        cartDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters "+ entity);
    }
    public Cart findById(Integer integer) {
        Cart test;
        cartDAO.openCurrentSession();
        test= cartDAO.findById(integer);
        cartDAO.closeCurrentSession();
        LOG.info("S-a gasit "+ integer);
        return test;
    }
    public void update(Cart entity){
        cartDAO.openCurrentSessionwithTransaction();
        cartDAO.update(entity);
        cartDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat "+ entity);

    }
    public void findAll() {
        cartDAO.openCurrentSessionwithTransaction();
        cartDAO.findAll();
        cartDAO.closeCurrentSessionwithTransaction();
        LOG.info("Toate datele: ");

    }
    public void deleteAll(){
        cartDAO.openCurrentSessionwithTransaction();
        cartDAO.deleteAll();
        cartDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-au sters toate ");

    }

}
