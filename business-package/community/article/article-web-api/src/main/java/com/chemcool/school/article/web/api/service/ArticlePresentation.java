package com.chemcool.school.article.web.api.service;

import com.chemcool.school.article.web.api.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The first layer for work db operations
 *
 * @autor Иван Полещук
 */
@Service
@RequiredArgsConstructor
public class ArticlePresentation {

    private final ArticleServiceLayer serviceLayer;

    public List<ArticleDto> getAllArticles() {
        return serviceLayer.getAllArticles();
    }

    public ArticleDto getArticleById(String id) {
        return serviceLayer.getArticleById(id);
    }

    public String createNewArticle(ArticleDto dto) {
        return serviceLayer.createNewArticle(dto);
    }

    public void updateArticle(ArticleDto dto) {
        serviceLayer.updateArticle(dto);
    }

    public void deleteArticleById(String id) {
        serviceLayer.deleteArticleById(id);
    }
}
