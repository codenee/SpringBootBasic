package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public Long  getId(){
        return id;
    }

    public void patch(Article articleEntity) {
        if(articleEntity.title != null){
            this.title = articleEntity.title;
        }
        if(articleEntity.content != null){
            this.content = articleEntity.content;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
