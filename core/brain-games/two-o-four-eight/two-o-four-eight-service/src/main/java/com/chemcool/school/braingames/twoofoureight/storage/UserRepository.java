package com.chemcool.school.braingames.twoofoureight.storage;

import com.chemcool.school.braingames.twoofoureight.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        this.users = List.of(
                new User("222", "test_name", "ROLE_USER_BASE"),
                new User("100", "testing_name", "ROLE_USER_BASE"));
    }

    public User getById(String id) {
        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElse(null);
    }

}
