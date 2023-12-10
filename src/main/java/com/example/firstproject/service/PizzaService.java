package com.example.firstproject.service;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Transactional
    public PizzaDto create(PizzaDto dto) {
        //피자 엔티티 생성
        Pizza pizza = Pizza.createPizza(dto);
        //피자 엔티티 DB에 저장
        Pizza created = pizzaRepository.save(pizza);
        //dto로 변환해 반환
        return PizzaDto.createPizzaDto(created);
    }

    @Transactional
    public PizzaDto show(Long id) {
        //피자 조회
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException("피자 조회 실패!"+"존재하는 id가 없습니다.")
                );

        return PizzaDto.createPizzaDto(pizza);
    }

    @Transactional
    public List<PizzaDto> index() {
        //피자 목록 조회
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaDto> dtos = new ArrayList<PizzaDto>();
        for (int i = 0; i < pizzas.size(); i++) {
            Pizza p = pizzas.get(i);
            PizzaDto dto = PizzaDto.createPizzaDto(p);
            dtos.add(dto);
        }
        /*List<PizzaDto> pizzas = pizzaRepository.findAll()
                .stream()
                .map(pizza -> PizzaDto.createPizzaDto(pizza))
                .collect(Collectors.toList());*/
        //결과 반환
        return dtos;
    }

    @Transactional
    public PizzaDto update(Long id, PizzaDto dto) {
        Pizza target = pizzaRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("피자 수정 실패!" + "수정할 피자가 없습니다.")
        );
        target.patch(dto);
        Pizza updated = pizzaRepository.save(target);
        return PizzaDto.createPizzaDto(updated);
    }

    public PizzaDto delete(Long id) {
        Pizza target = pizzaRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("피자 삭제 실패!"+ "삭제할 피자가 없습니다.")
        );
        pizzaRepository.delete(target);
        return PizzaDto.createPizzaDto(target);
    }
}
