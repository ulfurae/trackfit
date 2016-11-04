package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.UserGoal;
import project.persistence.entities.UserExercise;
import project.persistence.repositories.GoalRepository;
import project.service.GoalService;

import java.util.List;

@Service
public class GoalServiceImplementation implements GoalService {

    // Instance Variables
    GoalRepository repository;

    // Dependency Injection
    @Autowired
    public GoalServiceImplementation(GoalRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserGoal save(UserGoal userGoal) {
        return repository.save(userGoal);
    }
    
    @Override
    public UserExercise save(UserExercise userExercise) {
    	return repository.save(userExercise);
    }

    @Override
    public void delete(UserGoal userGoal) {
        repository.delete(userGoal);
    }

    @Override
    public List<UserGoal> findByName(int userID) {
        return repository.findByName(userID);
    }
}
