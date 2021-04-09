package com.chemcool.school.article.web.api.service;

import com.chemcool.school.article.domain.ArticlesTask;
import com.chemcool.school.article.domain.ArticlesTaskExample;
import com.chemcool.school.article.service.ArticleProxyService;
import com.chemcool.school.article.web.api.dto.ArticleDto;
import com.chemcool.school.article.web.api.exception.ArticleEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The second layer for work db operations
 *
 * @autor Иван Полещук
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceLayer {

    private final ArticleProxyService proxyService;

    public List<ArticleDto> getAllArticles() {
        List<ArticleDto> list = new ArrayList<>();
        for (ArticlesTask task : proxyService.getAll()) {
            list.add(new ArticleDto(task));
        }
        return list;
    }

    public ArticleDto getArticleById(String id) {
        return proxyService.getById(id).map(ArticleDto::new).orElse(null);
    }

    public String createNewArticle(ArticleDto dto) {
        validate(dto);
        return proxyService.add(
                new ArticlesTaskExample(
                        dto.getArticleTitle(),
                        dto.getArticleBody(),
                        dto.getArticleAuthor()
                )
        );
    }

    public void updateArticle(ArticleDto dto) {
        validate(dto);
        proxyService.update(
                new ArticlesTask(
                        dto.getArticleId(),
                        dto.getArticleTitle(),
                        dto.getArticleBody(),
                        dto.getArticleAuthor()
                )
        );
    }

    public void deleteArticleById(String id) {
        proxyService.delete(id);
    }

    private void validate(ArticleDto dto) {
        if (dto.getArticleBody().isEmpty() || dto.getArticleTitle().isEmpty()) {
            throw new ArticleEmptyException("Необходимые поля пустые, проверьте пожалуйста бланк заполнения статьи.");
        }
    }
}
