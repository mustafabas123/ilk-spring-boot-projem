package com.MyProject.MyProject.service.impl;

import com.MyProject.MyProject.Entitiy.Car;
import com.MyProject.MyProject.Entitiy.Order;
import com.MyProject.MyProject.Repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceimpld {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceimpld.class);
    private final CarServiceimpl carServiceimpl;
    private final OrderRepository orderRepository;

    public OrderServiceimpld(CarServiceimpl carServiceimpl, OrderRepository orderRepository) {
        this.carServiceimpl = carServiceimpl;
        this.orderRepository = orderRepository;
    }
    public Order putAnOrder(List<Integer> carIdList,String userName){
        List<Optional<Car>> carList=carIdList.stream()
                .map(carServiceimpl::findCarById).collect(Collectors.toList());

        Double totalPrice=carList.stream()
                .map(optionalCar->optionalCar.map(Car::getPrice).orElse(0.0)).reduce(0.0,Double::sum);

        Order order=Order.builder().UserName(userName).carIdList(carIdList).TotalPrice(totalPrice).build();

        return orderRepository.save(order);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
