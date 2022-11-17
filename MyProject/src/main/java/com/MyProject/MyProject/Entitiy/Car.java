package com.MyProject.MyProject.Entitiy;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Arabalar")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Marka;
    private Integer Model;
    private Double Price;
    private Integer Stock;

}
