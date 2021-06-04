package com.chemcool.school.games.twoofoureight.storage;


import com.chemcool.school.games.twoofoureight.domain.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScore, String> {
    UserScore findByUserId(String id);
}
