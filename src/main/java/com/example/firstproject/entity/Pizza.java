package com.example.firstproject.entity;

import com.example.firstproject.dto.PizzaDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String price;

    public Pizza(){}
    public Pizza(Long id, String name, String price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Pizza createPizza(PizzaDto dto) {
        if(dto.getId() != null){
            throw new IllegalArgumentException("피자 생성 실패! 피자의 id가 없어야 합니다.");
        }
        return new Pizza(
                dto.getId(),
                dto.getName(),
                dto.getPrice()
        );
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public void patch(PizzaDto dto) {
        if(this.id != dto.getId()){
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 Id가 입력됐습니다");
        }
        if(dto.getName() != null){
            this.name = dto.getName();
        }
        if(dto.getPrice() != null) {
            this.price = dto.getPrice();
        }
    }
}
