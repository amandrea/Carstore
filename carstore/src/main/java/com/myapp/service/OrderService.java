package com.myapp.service;
import com.myapp.dao.OrderDAO;

import com.myapp.entity.OrderEntity;
import org.apache.log4j.Logger;

public class OrderService {
    private static OrderDAO orderDAO;
    private final static Logger LOG= Logger.getLogger(OrderService.class.getName());

    public OrderService() {
        orderDAO =new OrderDAO();
    }

    public void persist(OrderEntity entity) {
        orderDAO.openCurrentSessionwithTransaction();
        orderDAO.persist(entity);
        orderDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat"+ entity.toString());
    }
    public void delete(OrderEntity entity)
    {
        orderDAO.openCurrentSessionwithTransaction();
        orderDAO.delete(entity);
        orderDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters "+ entity);
    }
    public OrderEntity findById(Integer integer) {
        OrderEntity test;
        orderDAO.openCurrentSession();
        test= orderDAO.findById(integer);
        orderDAO.closeCurrentSession();
        LOG.info("S-a gasit "+ integer);
        return test;
    }
    public void update(OrderEntity entity){
        orderDAO.openCurrentSessionwithTransaction();
        orderDAO.update(entity);
        orderDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat "+ entity);

    }
    public void findAll() {
        orderDAO.openCurrentSessionwithTransaction();
        orderDAO.findAll();
        orderDAO.closeCurrentSessionwithTransaction();
        LOG.info("Toate datele: ");

    }
    public void deleteAll(){
        orderDAO.openCurrentSessionwithTransaction();
        orderDAO.deleteAll();
        orderDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-au sters toate ");

    }

}
