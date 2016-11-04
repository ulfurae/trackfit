package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.UserGoal;
import project.persistence.entities.UserExercise;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface GoalRepository extends JpaRepository<UserGoal, Long> {

    UserGoal save(UserGoal userGoal);
    
    UserExercise save(UserExercise userExercise);

    void delete(UserGoal userGoal);

    List<UserGoal> findByName(int userID);
}
