package com.example.firstproject.entity;

import jakarta.persistence.*;

@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String price;

    public Coffee(){}

    public Coffee(Long id, String name, String price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Long getId(){
        return id;
    }

    public void patch(Coffee coffeeEntity){
        if(coffeeEntity.name != null){
            this.name = coffeeEntity.name;
        }
        if(coffeeEntity.price != null){
            this.price = coffeeEntity.price;
        }
    }
}
