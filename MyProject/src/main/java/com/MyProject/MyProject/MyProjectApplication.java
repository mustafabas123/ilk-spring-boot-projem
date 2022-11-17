package com.MyProject.MyProject;

import com.MyProject.MyProject.Entitiy.Car;
import com.MyProject.MyProject.Repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyProjectApplication  implements CommandLineRunner{
	private final CarRepository carRepository;

	public MyProjectApplication(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Car car1=Car.builder().Marka("Alfa Romeo").Model(2000).Price(350000.0).Stock(10).build();
		Car car2=Car.builder().Marka("BMW").Model(2010).Price(500000.0).Stock(2).build();
		Car car3=Car.builder().Marka("Mercedes").Model(2009).Price(450000.0).Stock(3).build();
		Car car4=Car.builder().Marka("Hyundai").Model(2012).Price(250000.0).Stock(15).build();
		Car car5=Car.builder().Marka("Opel").Model(2018).Price(450000.0).Stock(20).build();
		Car car6=Car.builder().Marka("Ferrari").Model(2013).Price(1500000.0).Stock(1).build();
		Car car7=Car.builder().Marka("Volkswagen").Model(2014).Price(350000.0).Stock(10).build();
		Car car8=Car.builder().Marka("Toyota").Model(2014).Price(200000.0).Stock(20).build();
		carRepository.saveAll(Arrays.asList(car1,car2,car3,car4,car5,car6,car7,car8));
	}
}
