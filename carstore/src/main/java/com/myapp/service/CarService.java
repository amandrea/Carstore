package com.myapp.service;

import com.myapp.dao.CarDAO;
import com.myapp.entity.Car;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarService {
    private static CarDAO carDao;
    private final static Logger LOG= Logger.getLogger(CarService.class.getName());

    public CarService() {
         carDao=new CarDAO();
    }

    public void persist(Car entity) {
        carDao.openCurrentSessionwithTransaction();
        carDao.persist(entity);
        carDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a salvat"+ entity.toString());
    }
    public void delete(Car entity)
    {
        carDao.openCurrentSessionwithTransaction();
        carDao.delete(entity);
        carDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a sters "+ entity);
    }
    public Car findById(Integer integer) {
        Car test;
        carDao.openCurrentSession();
        test=carDao.findById(integer);
        carDao.closeCurrentSession();
        LOG.info("S-a gasit "+ integer);
        return test;
    }
    public void update(Car entity){
        carDao.openCurrentSessionwithTransaction();
        carDao.update(entity);
        carDao.closeCurrentSessionwithTransaction();
        LOG.info("S-a updatat "+ entity);

    }
   public void findAll() {
       carDao.openCurrentSessionwithTransaction();
       carDao.findAll();
       carDao.closeCurrentSessionwithTransaction();
       LOG.info("Toate datele: ");

   }
public void deleteAll(){
    carDao.openCurrentSessionwithTransaction();
    carDao.deleteAll();
    carDao.closeCurrentSessionwithTransaction();
    LOG.info("S-au sters toate ");

}

}

