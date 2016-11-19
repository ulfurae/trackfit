package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.UserGoal;
import project.service.GoalService;

import java.util.Date;

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

        // set mock values into UserGoal for testing
        uGoal.setStartDate(new Date());
        uGoal.setEndDate(new Date());
        uGoal.setUserID(1);
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

        // Here we get all the UserExercises (in a reverse order) and add them to the model
        model.addAttribute("goals", goalService.findAllReverseOrder());

        // Return the view
        return "GoalLog";
    }
    
}
