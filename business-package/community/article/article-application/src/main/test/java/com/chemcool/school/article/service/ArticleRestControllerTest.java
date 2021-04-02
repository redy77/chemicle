package com.chemcool.school.article.service;

import com.chemcool.school.article.app.ArticleApplication;
import com.chemcool.school.article.domain.ArticlesTask;
import com.chemcool.school.article.web.api.dto.ArticleDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests
 *
 * @version 1.0
 * @autor Иван Полещук
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArticleApplication.class)
@AutoConfigureMockMvc
@Sql(value = {"/sql/create-article-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/clean-of-test-db.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ArticleRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public final String BASE_URL = "/articles/v1.0/";

    public ArticleDto articleDtoForCreateTest =
            new ArticleDto("3", "Test_Title", "Test_Body", "test_author_by_create");

    @Test
    public void getAllArticlesFromDbTest() throws Exception {
        List<ArticlesTask> resFromDbList = entityManager.createQuery("from ArticlesTask at").getResultList();
        boolean checkSumForResFromDbList = resFromDbList.isEmpty();

        mockMvc.perform(get(BASE_URL))
                .andDo(print())
                .andExpect(status().isOk()); //проверка статуса (200)

        Assert.assertFalse(checkSumForResFromDbList); //проверка того что лист получившийся из бд не пуст
    }

    @Test
    public void getArticleByIdFromDbTest() throws Exception {
        ArticlesTask resFromDb = (ArticlesTask) entityManager.createQuery("from ArticlesTask at where at.articleId = 'id_for_get_by_id_method'").getSingleResult();

        String resGetAll = mockMvc.perform(get(BASE_URL + "/{id}", resFromDb.getArticleId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assert.assertTrue(resGetAll.contains(resFromDb.getArticleId()));
    }

    @Test
    public void createNewArticleFromDbTest() throws Exception {
        List<ArticlesTask> beforeQueryList = entityManager.createQuery("from ArticlesTask").getResultList();
        int beforeSize = beforeQueryList.size();

        String resNewArticles = mockMvc.perform(post(BASE_URL)
                .content(objectMapper.writeValueAsString(articleDtoForCreateTest))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(); //извлекаю "article_author" из String resNewArticles

        timer(1000); //таймер для того чтобы успела обновиться бд

        List<ArticlesTask> afterQueryList = entityManager.createQuery("from ArticlesTask").getResultList();
        int afterSize = afterQueryList.size();

        ArticlesTask resFromDbByAuthor = (ArticlesTask) entityManager.createQuery("from ArticlesTask at where at.articleAuthor = 'test_author_by_create'").getSingleResult();

        Assert.assertEquals(beforeSize + 1, afterSize); //проверка на то что стало на 1 запись больше
        Assert.assertTrue(resFromDbByAuthor.toString().contains(resNewArticles)); //проверка что resFromDb.toString() содержит поле resNewArticles()
    }

    @Test
    @Sql(value = {"/sql/clean-of-test-db.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/create-article-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void updateArticleFromDbTest() throws Exception {
        List<ArticlesTask> beforeQueryList = entityManager.createQuery("from ArticlesTask at").getResultList();
        int beforeSize = beforeQueryList.size();

        ArticlesTask resFromDb = (ArticlesTask) entityManager.createQuery("from ArticlesTask at where at.articleId = 'id_for_update_method'").getSingleResult();

        ArticleDto articleDtoForUpdateTest = new ArticleDto(resFromDb.getArticleId(), "TEST_TITLE", "TEST_BODY", "TEST_AUTHOR");
        String resUpdateArticle = mockMvc.perform(put(BASE_URL)
                .content(objectMapper.writeValueAsString(articleDtoForUpdateTest))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(); //получаю ID


        List<ArticlesTask> afterQueryList = entityManager.createQuery("from ArticlesTask at").getResultList();
        int afterSize = afterQueryList.size();

        Assert.assertEquals(resFromDb.getArticleId(), resUpdateArticle); //проверка на соответствие ID обновлённого объекта
        Assert.assertTrue(resUpdateArticle.contains(resFromDb.getArticleId())); //проверка на содержание ID в
        Assert.assertEquals(beforeSize, afterSize); //проверка на то что не стало больше 4 элементов
    }

    @Test
    public void deleteArticleFromDbTest() throws Exception {
        List<ArticlesTask> beforeQueryList = entityManager.createQuery("from ArticlesTask at").getResultList();
        int beforeSize = beforeQueryList.size();

        ArticlesTask resFromDb = (ArticlesTask) entityManager.createQuery("from ArticlesTask at where at.articleId = 'id_for_delete_method'").getSingleResult();

        String resDeleteArticle = mockMvc.perform(delete(BASE_URL + "/{id}", resFromDb.getArticleId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<ArticlesTask> afterQueryList = entityManager.createQuery("from ArticlesTask at").getResultList();
        int afterSize = afterQueryList.size();

        Assert.assertEquals(resFromDb.getArticleId(), resDeleteArticle); //проверка что id удалённого равно id переданного на удаление
        Assert.assertEquals(beforeSize - 1, afterSize);//проверка что стало на 1 запись в БД меньше
    }

    public void timer(int milliseconds) {  /* таймер чтобы кафка успевала сохранить статью иначе тесты проваливаются*/
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
