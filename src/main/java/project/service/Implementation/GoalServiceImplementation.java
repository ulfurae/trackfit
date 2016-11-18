package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Exercise;
import project.persistence.entities.UserExercise;
import project.persistence.entities.UserGoal;
import project.persistence.repositories.GoalRepository;
import project.service.GoalService;

import java.util.Collections;
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
    public void delete(UserGoal userGoal) {
        repository.delete(userGoal);
    }

    @Override
    public List<UserGoal> findAll() {
        return repository.findAll();
    }

    @Override
    public List<UserGoal> findAllReverseOrder() {
        // Get all the userExercises
        List<UserGoal> userGoals = repository.findAll();

        // Reverse the list
        Collections.reverse(userGoals);

        return userGoals;
    }

    @Override
    public UserGoal findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<UserGoal> findByUserID(int userID) {
        return repository.findByUserID(userID);
    }
    
}
