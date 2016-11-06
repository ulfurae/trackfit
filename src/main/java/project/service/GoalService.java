package project.service;

import project.persistence.entities.UserGoal;

import java.util.List;

public interface GoalService {


    /**
     * Save a {@link UserGoal}
     * @param userGoal {@link UserGoal} to be saved
     * @return {@link UserGoal} that was saved
     */
    UserGoal save(UserGoal userGoal);

    
    /**
     * Delete {@link UserGoal}
     * @param userGoal {@link UserGoal} to be deleted
     */
    void delete(UserGoal userGoal);

    /**
     * Find all {@link UserGoal}s with {@link Integer userID}
     * @param userID {@link Integer}
     * @return All {@link UserGoal}s with the {@link Integer userID} passed
     */
    List<UserGoal> findByName(int userID);

}
