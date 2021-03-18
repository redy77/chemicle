package com.chemcool.school.article.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity for event
 *
 * @autor Иван Полещук
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@TypeDefs(@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class))
@Table(name = "article_task_event")
public class ArticleTaskEvent {

    @Id
    @Column(name = "id")
    private String TaskEventId;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "occurring_comtext")
    private String occurringContext;

    @Column(name = "occurring_context_time")
    private LocalDateTime occurringContextTime;

    @Column(name = "event_type")
    private ArticleEventType eventType;

    @Column(name = "event_version")
    private String eventVersion;

    @Column(name = "entity_id")
    private String entityId;

    @Type(type = "jsonb")
    @Column(name = "payload", columnDefinition = "jsonb")
    private ArticlesTask payload;

    public static ArticleTaskEvent createEvent(ArticlesTask task, String authorId, ArticleEventType eventType) {
        return new ArticleTaskEvent(
                UUID.randomUUID().toString(),
                authorId,
                "ArticleTaskEvent",
                LocalDateTime.now(),
                eventType,
                "1.0",
                task.getArticleId(),
                task
        );
    }
}
