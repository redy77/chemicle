package com.chemcool.school.repo;

import com.chemcool.school.entities.Comment;
import com.chemcool.school.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
}
