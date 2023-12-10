package com.example.firstproject.dto;

import com.example.firstproject.entity.Comment;
import lombok.Getter;

@Getter
public class CommentDto {
    private Long id;    //댓글의 id
    private Long articleId; //댓글의 부모 id
    private String nickname; //댓글 작성자
    private String body; //댓글 본문
    public CommentDto(){}
    public CommentDto(Long id, Long articleId, String nickname, String body){
        this.id = id;
        this.articleId = articleId;
        this.nickname = nickname;
        this.body = body;
    }

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody()
        );
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", nickname='" + nickname + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
/*
    public Long getId() {
        return id;
    }
    public Long getArticleId(){
        return articleId;
    }
    public String getNickname(){
        return nickname;
    }
    public String getBody(){
        return body;
    }
 */
}
