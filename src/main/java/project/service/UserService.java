package project.service;

import project.persistence.entities.User;

import java.util.List;

public interface UserService {


    /**
     * Save a {@link User}
     * @param user {@link User} to be saved
     * @return {@link User} that was saved
     */
    User save(User user);

    /**
     * Find all {@link User}s with {@link String userName}
     * @param userName {@link String}
     * @return All {@link User}s with the {@link String userName} passed
     */
    List<User> findByName(String userName);

}
