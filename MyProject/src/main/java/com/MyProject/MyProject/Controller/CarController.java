package com.MyProject.MyProject.Controller;

import com.MyProject.MyProject.Entitiy.Car;
import com.MyProject.MyProject.Entitiy.Order;
import com.MyProject.MyProject.Repository.CarRepository;
import com.MyProject.MyProject.dto.CarOrderRequest;
import com.MyProject.MyProject.service.impl.CarServiceimpl;
import com.MyProject.MyProject.service.impl.OrderServiceimpld;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController//apinin disari acilacagini belirtiyoruz
@RequestMapping("v1/car")//bu apinin hangi adreste yayinlanicagini özelleştirebiliriz
public class CarController {


    private final CarServiceimpl carServiceimpl;
    private final CarRepository carRepository;
    private final OrderServiceimpld orderServiceimpld;

    public CarController(CarServiceimpl carServiceimpl, CarRepository carRepository, OrderServiceimpld orderServiceimpld) {

        this.carServiceimpl = carServiceimpl;
        this.carRepository = carRepository;
        this.orderServiceimpld = orderServiceimpld;
    }
    @PostMapping("/create")
    public ResponseEntity<Car> addCar(Car car){//requestBody sayesinde json nesnemizi Car clasıyla eşliyoruz
        Car addCar=Car.builder().Marka(car.getMarka()).Model(car.getModel()).Price(car.getPrice())
                .Stock(car.getStock()).build();
        carRepository.save(addCar);
        return ResponseEntity.ok(addCar);
    }
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> carsList=carServiceimpl.getAllCars();
        return ResponseEntity.ok(carsList);
    }
    @GetMapping()
    public ResponseEntity<String> merhaba(){
        return ResponseEntity.ok("Mireba dunya");
    }
    @PostMapping
    public ResponseEntity<Order> putAndOrder(String carIdList,String userName){
        String [] cars=null;
        cars=carIdList.split(",");
        int[] sayilar=new int[cars.length];
        for (int i=0;i<cars.length;i++){
            sayilar[i]=Integer.valueOf(cars[i]);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(Integer s:sayilar) list.add(s);
        Order order=orderServiceimpld.putAnOrder(list,userName);
        return ResponseEntity.ok(order);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orderList=orderServiceimpld.getAllOrders();
        return ResponseEntity.ok(orderList);
    }
}
