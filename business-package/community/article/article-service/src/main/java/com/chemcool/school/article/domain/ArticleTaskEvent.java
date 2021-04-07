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
    @Column(name = "event_id")
    private String TaskEventId;

    @Column(name = "event_author_id")
    private String authorId;

    @Column(name = "event_occurring_context")
    private String occurringContext;

    @Column(name = "event_occurring_context_time")
    private LocalDateTime occurringContextTime;

    @Column(name = "event_type")
    private ArticleEventType eventType;

    @Column(name = "event_version")
    private String eventVersion;

    @Column(name = "event_entity_id")
    private String entityId;

    @Type(type = "jsonb")
    @Column(name = "event_payload", columnDefinition = "jsonb")
    private ArticlesTask payload;

    public static ArticleTaskEvent createEvent(ArticlesTask task, ArticleEventType eventType) {
        return new ArticleTaskEvent(
                UUID.randomUUID().toString(),
                "AuthorIdArticleTaskEvent",
                "ArticleTaskEvent",
                LocalDateTime.now(),
                eventType,
                "1.0",
                task.getArticleId(),
                task
        );
    }
}
