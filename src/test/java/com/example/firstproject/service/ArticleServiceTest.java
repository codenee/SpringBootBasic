package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.hibernate.query.internal.ModelPartResultMementoBasicImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        //1.예상 데이터
        Article a = new Article(1L, "가가가가","1111");
        Article b = new Article(2L, "나나나나","2222");
        Article c = new Article(3L,"다다다다","3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));
        //2. 실제 데이터
        List<Article> articles = articleService.index();
        //3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_success_exist_id() {  //성공_존재하는_id_입력
        //1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        //2. 실제 데이터
        Article article = articleService.show(id);
        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_Fail_no_exist_id() {//실패_존재하지_않는_id_입력
        //1. 예상 데이터
        Long id = -1L;
        Article expected = null;
        //2. 실제 데이터
        Article article = articleService.show(id);
        //3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_success_title_content() {//성공_title과 content만 있는 dto 입력
        //1.예상 데이터
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expected = new Article(4L, title,content);
        //2. 실제 데이터
        Article article = articleService.create(dto);
        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    @Transactional
    void create_fail_id_dto() { //실패_id가 포함된_dto_입력
        //1.예상 데이터
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        //2. 실제 데이터
        Article article = articleService.create(dto);
        //3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_success_id_title_content_dto() {//성공_존재하는_id와_title_content가 있는 dto입력
        //1.예상 데이터 작성하기
        Long id = 1L;
        String title = "update";
        String content = "update";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);
        //2. 실제 데이터 획득하기
        Article article = articleService.update(id,dto);

        //3. 예상 데이터와 실제 비교해 데이터 검증하기
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void update_success_id_title_dto() {//성공_존재하는_id와_title만 있는 dto입력
        //1.예상 데이터 작성하기
        Long id = 1L;
        String title = "update";
        String content = "1111";
        ArticleForm dto = new ArticleForm(id, title, null);
        Article expected = new Article(id, title, content);
        //2. 실제 데이터 획득하기
        Article article = articleService.update(id, dto);

        //3. 예상 데이터와 실제 비교해 데이터 검증하기
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    @Transactional
    void update_fail_no_exist_dto() { //실패_존재하지 않는 id의 dto입력
        //1.예상 데이터 작성하기
        Long id = -1L;
        ArticleForm dto = new ArticleForm(id,null,null);
        Article expected = null;
        //2. 실제 데이터 획득하기
        Article article = articleService.update(id,dto);

        //3. 예상 데이터와 실제 비교해 데이터 검증하기
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void delete_success_exist_id() { //성공_존재하는_id_입력
        //1.예상 데이터 작성하기
        Long id = 1L;
        String title = "가가가가";
        String content = "1111";
        Article expected = new Article(id, title, content);
        //2. 실제 데이터 획득하기
        Article article = articleService.delete(id);
        //3. 예상 데이터와 실제 데이터 비교해 데이터 검증하기
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    @Transactional
    void delete_fail_no_exist_id() { //실패_존재하지 않는_id_입력
        //1.예상 데이터 작성하기
        Long id = -1L;
        Article expected = null;
        //2. 실제 데이터 획득하기
        Article article = articleService.delete(id);
        //3. 예상 데이터와 실제 데이터 비교해 데이터 검증하기
        assertEquals(expected, article);
    }
}