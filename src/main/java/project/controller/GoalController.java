package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.persistence.entities.UserGoal;
import project.service.GoalService;
import project.service.Implementation.UserServiceImplementation;


@Controller
public class GoalController {

    // Instance Variables
    GoalService goalService;

    // Dependency Injection
    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    // GET method that returns the correct view for the URL /addGoal
    @RequestMapping(value = "/addGoal", method = RequestMethod.GET)
    public String addGoalGet(Model model){

        /* TODO: make this functional
        List el =  exerciseService.findAllReverseOrder();
        List el2 = new ArrayList();
        for(Object x : el) {
            Exercise b = (Exercise) x;
            el2.add(b.getName());
        }
        model.addAttribute("exercises", el2);
        */

        // connecting the UserGoal object to the form
        model.addAttribute("goalForm",new UserGoal());

        return "GoalAdd";
    }

    // Method that receives the POST request on the URL /addGoal and receives the ModelAttribute("addGoal")
    @RequestMapping(value = "/addGoal", method = RequestMethod.POST)
    public String addGoalPost(@ModelAttribute("addGoal") UserGoal uGoal, Model model) {

        // get logged in user from global variable UserServiceImplementation.loggedInUser
        User user = UserServiceImplementation.loggedInUser;

        uGoal.setUserID(user.getId());
        uGoal.setStatus("not completed");

        // Save the UserGoal that is received from the form
        goalService.save(uGoal);

        // Refresh the form with a new UserGoal
        model.addAttribute("goalForm", new UserGoal());

        // Return the view
        return "GoalAdd";
    }
    
 // GET method that returns the view for the URL /viewPerformace
    @RequestMapping(value = "/goalLog", method = RequestMethod.GET)
    public String viewGoalLogGet(Model model){

        // get logged in user from global variable UserServiceImplementation.loggedInUser
        User user = UserServiceImplementation.loggedInUser;

        // Here we get all the UserExercises by userID and add them to the model
        model.addAttribute("goals", goalService.findAllUserGoals(user.getId()));

        // Return the view
        return "GoalLog";
    }

    // Method that returns the correct view for the URL /postit/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    // This method finds all Postit Notes posted by someone with the requested {name}
    // and returns a list with all those Postit Notes.
    @RequestMapping(value = "/goal/{id}", method = RequestMethod.GET)
    public String userGoalGet(@PathVariable Long id,
                                             Model model){

        // get logged in user from global variable UserServiceImplementation.loggedInUser
        User user = UserServiceImplementation.loggedInUser;

        // Get UserGoal with this id and add it to the model
        model.addAttribute("goal", goalService.findOneUserGoal(user.getId(), id).get(0));


        // Return the view
        return "UserGoal";
    }
    
}
