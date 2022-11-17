package com.MyProject.MyProject.service.impl;

import com.MyProject.MyProject.Entitiy.Car;
import com.MyProject.MyProject.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceimpl {
    private final CarRepository carRepository;

    public CarServiceimpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public Optional <Car> findCarById(Integer carId){

        return carRepository.findById(carId);
    }
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

}
