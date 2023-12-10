package com.example.firstproject.api;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import com.example.firstproject.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaApiController {

    @Autowired
    private PizzaService pizzaService;

    //1. 생성
    @PostMapping("/api/pizzas")
    public ResponseEntity<PizzaDto> create(@RequestBody PizzaDto dto){
        //서비스에 위임
        PizzaDto createdDto = pizzaService.create(dto);
        //결과 반환
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
    //2. 조회 - 1 단건 조회
    @GetMapping("/api/pizzas/{id}")
    public ResponseEntity<PizzaDto> show(@PathVariable Long id){
        //서비스에 위임
        PizzaDto showDto = pizzaService.show(id);
        //결과 반환
        return ResponseEntity.status(HttpStatus.OK).body(showDto);
    }
    //2. 조회 - 2 목록 조회
    @GetMapping("/api/pizzas")
    public ResponseEntity<List<PizzaDto>> index(){
        //서비스에 위임
        List<PizzaDto> dtos = pizzaService.index();
        //결과 반환
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }


    //3. 수정
    @PatchMapping("/api/pizzas/{id}")
    public ResponseEntity<PizzaDto> update(@PathVariable Long id, @RequestBody PizzaDto dto){
        //서비스에 위임
        PizzaDto updated = pizzaService.update(id, dto);
        //결과반환
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    //4. 삭제
    @DeleteMapping("/api/pizzas/{id}")
    public ResponseEntity<PizzaDto> delete(@PathVariable Long id){
        PizzaDto deleted = pizzaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}
