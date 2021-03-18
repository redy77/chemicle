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
    @ApiOperation("Возвращает дто сущности статьи по химии по ID.")
    public ArticleDto getTaskById(@PathVariable String id) {
        return presentation.getArticleById(id);
    }

    @PostMapping
    @ApiOperation("Создает новую сущность статьи по химии.")
    @ResponseBody
    public String createNewTask(@RequestBody ArticleDto task) {
        return presentation.createNewArticle(task);
    }

    @PutMapping
    @ApiOperation("Обновляет существующую сущность статьи по химии.")
    @ResponseBody
    public String updateTask(@RequestBody ArticleDto task) {
        presentation.updateArticle(task);
        return "Update task UUID: " + task.getArticleId();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаляет существующую сущность статьи по химии по ID.")
    public String deleteTask(@PathVariable String id) {
        presentation.deleteArticleById(id);
        return "Сущность с UUID = " + id + " была успешно удалена.";
    }
}
