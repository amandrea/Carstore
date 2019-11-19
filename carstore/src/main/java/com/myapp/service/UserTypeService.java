package com.myapp.service;
import com.myapp.dao.UserTypeDAO;

import com.myapp.entity.UserType;
import org.apache.log4j.Logger;

public class UserTypeService {
    private static UserTypeDAO userTypeDAO;
    private final static Logger LOG= Logger.getLogger(UserTypeService.class.getName());

    public UserTypeService() {
        userTypeDAO =new UserTypeDAO();
    }

    public void persist(UserType entity) {
        userTypeDAO.openCurrentSessionwithTransaction();
        userTypeDAO.persist(entity);
        userTypeDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat"+ entity.toString());
    }
    public void delete(UserType entity)
    {
        userTypeDAO.openCurrentSessionwithTransaction();
        userTypeDAO.delete(entity);
        userTypeDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters "+ entity);
    }
    public UserType findById(Integer integer) {
        UserType test;
        userTypeDAO.openCurrentSession();
        test= userTypeDAO.findById(integer);
        userTypeDAO.closeCurrentSession();
        LOG.info("S-a gasit "+ integer);
        return test;
    }
    public void update(UserType entity){
        userTypeDAO.openCurrentSessionwithTransaction();
        userTypeDAO.update(entity);
        userTypeDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat "+ entity);

    }
    public void findAll() {
        userTypeDAO.openCurrentSessionwithTransaction();
        userTypeDAO.findAll();
        userTypeDAO.closeCurrentSessionwithTransaction();
        LOG.info("Toate datele: ");

    }
    public void deleteAll(){
        userTypeDAO.openCurrentSessionwithTransaction();
        userTypeDAO.deleteAll();
        userTypeDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-au sters toate ");

    }

}
