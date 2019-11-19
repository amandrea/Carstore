package com.myapp.service;
import com.myapp.dao.UserDAO;

import com.myapp.entity.User;
import org.apache.log4j.Logger;

public class UserService {
    private static UserDAO userDAO;
    private final static Logger LOG= Logger.getLogger(UserService.class.getName());

    public UserService() {
        userDAO =new UserDAO();
    }

    public void persist(User entity) {
        userDAO.openCurrentSessionwithTransaction();
        userDAO.persist(entity);
        userDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat"+ entity.toString());
    }
    public void delete(User entity)
    {
        userDAO.openCurrentSessionwithTransaction();
        userDAO.delete(entity);
        userDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters "+ entity);
    }
    public User findById(Integer integer) {
        User test;
        userDAO.openCurrentSession();
        test= userDAO.findById(integer);
        userDAO.closeCurrentSession();
        LOG.info("S-a gasit "+ integer);
        return test;
    }
    public void update(User entity){
        userDAO.openCurrentSessionwithTransaction();
        userDAO.update(entity);
        userDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat "+ entity);

    }
    public void findAll() {
        userDAO.openCurrentSessionwithTransaction();
        userDAO.findAll();
        userDAO.closeCurrentSessionwithTransaction();
        LOG.info("Toate datele: ");

    }
    public void deleteAll(){
        userDAO.openCurrentSessionwithTransaction();
        userDAO.deleteAll();
        userDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-au sters toate ");

    }

}