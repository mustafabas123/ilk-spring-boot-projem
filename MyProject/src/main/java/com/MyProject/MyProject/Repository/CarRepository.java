package com.MyProject.MyProject.Repository;

import com.MyProject.MyProject.Entitiy.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
    //ilk parametre hangi interface icin kurduysak bu Repository onu dahil ediyoruz
    //ikinci paramaetre ise primarykey'in tipi
}
