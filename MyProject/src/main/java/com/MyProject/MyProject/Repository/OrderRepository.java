package com.MyProject.MyProject.Repository;

import com.MyProject.MyProject.Entitiy.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
