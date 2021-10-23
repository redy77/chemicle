package com.chemcool.school.constructor.service;

import com.chemcool.school.constructor.domain.FixedAnswerTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixedCrudRepository extends CrudRepository<FixedAnswerTask,String> {
    List<FixedAnswerTask> findAll();
}
