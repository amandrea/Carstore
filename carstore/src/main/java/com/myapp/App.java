package com.myapp;

import com.myapp.entity.*;
import com.myapp.service.*;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class App {
  private final static Logger LOG= Logger.getLogger(App.class.getName());

  public static void main(String[] args) {
      SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
      Date date = new Date(System.currentTimeMillis());
      Car car=new Car();
      Car car1=new Car();
      Car car2=new Car();
      CarService service=new CarService();
      car.setName("Toyota");
      car.setPrice(30000);
      car.setDescription("Top notch car");
      service.persist(car);
      car1.setName("Honda");
      car1.setPrice(20000);
      car1.setDescription("The best one");
      service.persist(car1);
      car2.setName("Nissan");
      car2.setPrice(40000);
      car2.setDescription("Best car ever");
      service.persist(car2);
      LOG.info(service.findById(3).getName());
      car1.setPrice(10000);
      service.update(car1);
      Cart cart=new Cart();
      cart.setNumberOfProducts(3);
      cart.setTotalPrice(10000);
      User user=new User();
      cart.setUser(user);
      CartService cartService=new CartService();
     // cartService.persist(cart);
      Category category=new Category();
      Order order= new Order();
      UserType userType=new UserType();
      CategoryService categoryService=new CategoryService();
      OrderService orderService=new OrderService();
      UserTypeService userTypeService=new UserTypeService();
      UserService userService=new UserService();
      user.setCart(cart);

      user.setAddress("Summer Street");
      user.setcCNumber("21134235233");
      user.setCityRegion("NY City");
      user.setEmail("email@email.com");
      user.setPhone("0777070707");
      user.setUserName("Gray");
      userService.persist(user);
      cart.getUser().getUserName().toString();
      LOG.info("Name "+ cart.getUser().getUserName());
  }
    }

