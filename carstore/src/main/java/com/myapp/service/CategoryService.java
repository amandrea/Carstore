package com.myapp.service;
import com.myapp.dao.CategoryDAO;
import com.myapp.entity.Category;

import org.apache.log4j.Logger;

public class CategoryService {
    private static CategoryDAO categoryDAO;
    private final static Logger LOG= Logger.getLogger(CategoryService.class.getName());

    public CategoryService() {
        categoryDAO =new CategoryDAO();
    }

    public void persist(Category entity) {
        categoryDAO.openCurrentSessionwithTransaction();
        categoryDAO.persist(entity);
        categoryDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat"+ entity.toString());
    }
    public void delete(Category entity)
    {
        categoryDAO.openCurrentSessionwithTransaction();
        categoryDAO.delete(entity);
        categoryDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters "+ entity);
    }
    public Category findById(Integer integer) {
        Category test;
        categoryDAO.openCurrentSession();
        test= categoryDAO.findById(integer);
        categoryDAO.closeCurrentSession();
        LOG.info("S-a gasit "+ integer);
        return test;
    }
    public void update(Category entity){
        categoryDAO.openCurrentSessionwithTransaction();
        categoryDAO.update(entity);
        categoryDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat "+ entity);

    }
    public void findAll() {
        categoryDAO.openCurrentSessionwithTransaction();
        categoryDAO.findAll();
        categoryDAO.closeCurrentSessionwithTransaction();
        LOG.info("Toate datele: ");

    }
    public void deleteAll(){
        categoryDAO.openCurrentSessionwithTransaction();
        categoryDAO.deleteAll();
        categoryDAO.closeCurrentSessionwithTransaction();
        LOG.info("S-au sters toate ");

    }

}
