package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Exercise;
import project.service.ExerciseService;
import project.service.UserService;

@Controller
public class UserController {

    // Instance Variables
    UserService userService;

    // Dependency Injection
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Method that returns the correct view for the URL /postit
    // This handles the GET request for this URL
    // Notice the `method = RequestMethod.GET` part
    @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public String viewProfileGetView(Model model){

        // Add a new Postit Note to the model for the form
        // If you look at the form in addExercise.jsp, you can see that we
        // reference this attribute there by the name `addExercise`.
       // model.addAttribute("exerciseForm",new Exercise());

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        //model.addAttribute("exercises", exerciseService.findAllReverseOrder());

        // Return the view
        return "Profile";
    }

}
