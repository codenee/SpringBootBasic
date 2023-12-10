package com.example.firstproject.repository;

import com.example.firstproject.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    @Override
    ArrayList<Pizza> findAll();

}
