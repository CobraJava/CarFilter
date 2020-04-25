package com.shop.car.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    @PositiveOrZero
    private Float price;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private List<Picture> pictures = new ArrayList<>();

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private List<CarAttribute> carAttributes = new ArrayList<>();

    @OneToOne
    private Brand brand;

    @OneToOne
    private PassengersCapacity passengersCapacity;

    @OneToOne
    private BodyStyle bodyStyle;

    @OneToOne
    private DriveTrain driveTrain;

    @OneToOne
    private Transmission transmission;

    @OneToOne
    private FuelType fuelType;



}
