package project.service;

import project.persistence.entities.UserExercise;

import java.util.List;

public interface UserExerciseService {

    /**
     * Save a {@link UserExercise}
     * @param exercise {@link UserExercise} to be saved
     * @return {@link UserExercise} that was saved
     */
    UserExercise save(UserExercise userexercise);

    /**
     * Delete {@link UserExercise}
     * @param exercise {@link UserExercise} to be deleted
     */
    void delete(UserExercise userexercise);

    /**
     * Get all {@link UserExercise}s
     * @return A list of {@link UserExercise}s
     */
    List<UserExercise> findAll();

    /**
     * Get all {@link UserExercise}s in a reverse order
     * @return A reversed list of {@link UserExercise}s
     */
    List<UserExercise> findAllReverseOrder();

    /**
     * Find a {@link UserExercise} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link UserExercise} with {@link Long id}
     */
    UserExercise findOne(Long id);

    /**
     * Find all {@link UserExercise}s with {@link String name}
     * @param name {@link String}
     * @return All {@link UserExercise}s with the {@link String name} passed
     */
    List<UserExercise> findByName(String name);

    /**
     * Find all {@link UserExercise}s with {@link String type}
     * @param name {@link String}
     * @return All {@link UserExercise}s with the {@link String type} passed
     */
    List<UserExercise> findByType(String type);
}
