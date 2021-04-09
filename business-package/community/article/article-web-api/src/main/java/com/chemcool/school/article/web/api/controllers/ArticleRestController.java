package com.chemcool.school.article.web.api.controllers;

import com.chemcool.school.article.web.api.dto.ArticleDto;
import com.chemcool.school.article.web.api.service.ArticlePresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller
 *
 * @autor Иван Полещук
 */
@RestController
@RequestMapping("/articles/v1.0/")
@RequiredArgsConstructor
public class ArticleRestController {

    private final ArticlePresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает все статьи по химии.")
    public List<ArticleDto> getAllArticles() {
        return presentation.getAllArticles();
    }

    @GetMapping("/{id}")
    @ApiOperation("Возвращает дто статьи по химии по ID.")
    public ArticleDto getArticleById(@PathVariable String id) {
        return presentation.getArticleById(id);
    }

    @PostMapping
    @ApiOperation("Создает новую статью по химии.")
    public String createNewArticle(@RequestBody ArticleDto task) {
        presentation.createNewArticle(task);
        return task.getArticleAuthor();
    }

    @PutMapping
    @ApiOperation("Обновляет существующую статью по химии по ID")
    public String updateArticle(@RequestBody ArticleDto task) {
        presentation.updateArticle(task);
        return task.getArticleId(); //"Обновлена статья с ID: " +
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляет существующую статью по химии по ID.")
    public String deleteArticleById(@PathVariable String id) {
        presentation.deleteArticleById(id);
        return id; //+ "Статья с ID = " +" была успешно удалена.";
    }
}
