package com.MyProject.MyProject.Entitiy;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Data
@Getter
@Setter
@Builder
@Entity(name = "carOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Otomatik artirma
    private Integer id;

    private String UserName;
    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> carIdList;
    private Double TotalPrice;
}
