package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;
import project.service.UserService;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    // Instance Variables
    UserRepository repository;

    // Dependency Injection
    @Autowired
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findByName(String userName) {
        return repository.findByName(userName);
    }
}
