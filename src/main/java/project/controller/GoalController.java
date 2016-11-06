package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.UserGoal;
import project.service.GoalService;

@Controller
public class GoalController {

    // Instance Variables
    GoalService goalService;

    // Dependency Injection
    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    // Method that returns the correct view for the URL /addGoal
    @RequestMapping(value = "/addGoal", method = RequestMethod.GET)
    public String addGoalViewGet(Model model){

        // connect UserGoal object to the form
        model.addAttribute("goalForm",new UserGoal());

        // Return the view
        return "GoalAdd";
    }

    // TODO: Á eftir að vinna í þessu !!!!!
    
}
