package com.example.firstproject.dto;

import com.example.firstproject.entity.Pizza;
import lombok.Getter;

@Getter
public class PizzaDto {
    private Long id;
    private String name;
    private String price;
    public PizzaDto(){}
    public PizzaDto(Long id, String name, String price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static PizzaDto createPizzaDto(Pizza created) {
        return new PizzaDto(
                created.getId(),
                created.getName(),
                created.getPrice()
        );
    }

    @Override
    public String toString() {
        return "PizzaDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
