package com.myapp;

import com.myapp.entity.Car;
import com.myapp.service.CarService;
import org.apache.log4j.Logger;


public class App {
  private final static Logger LOG= Logger.getLogger(App.class.getName());

  public static void main(String[] args) {
      Car car=new Car();
      LOG.info("S-a creat un obiect nou");
      Car car1=new Car();
      Car car2=new Car();
      car.setName("Honda");
      car.setId(0);
      car1.setName("Toyota");
      car1.setId(1);
      car2.setName("Honda");
      car2.setId(2);
      CarService carService=new CarService();
      carService.persist(car);
      carService.findAll();
      carService.deleteAll();

    }
    }

