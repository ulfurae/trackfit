package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.UserExercise;
import project.persistence.entities.UserGoal;

import java.util.List;

public interface GoalRepository extends JpaRepository<UserGoal, Long> {

    UserGoal save(UserGoal userGoal);

    void delete(UserGoal userGoal);
    
    UserGoal findOne(Long id);

    List<UserGoal> findByUserID(int userID);
}
