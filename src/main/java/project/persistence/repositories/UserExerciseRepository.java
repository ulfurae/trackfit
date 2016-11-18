package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.UserExercise;

import java.util.List;

public interface UserExerciseRepository extends JpaRepository<UserExercise, Long> {

    UserExercise save(UserExercise userExercise);

    void delete(UserExercise userExercise);

    UserExercise findOne(Long id);

    List<UserExercise> findByUserID(Long userID);

}
