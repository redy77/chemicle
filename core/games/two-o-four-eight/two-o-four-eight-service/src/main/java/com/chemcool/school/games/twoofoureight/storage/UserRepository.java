package com.chemcool.school.games.twoofoureight.storage;

import com.chemcool.school.games.twoofoureight.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User getUserById(String id);
}
