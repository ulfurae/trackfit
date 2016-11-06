package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Exercise;
import project.persistence.entities.User;
import project.persistence.entities.BMI;
import project.service.UserService;
import project.service.FormulaService;

@Controller
public class UserController {

    // Instance Variables
    UserService userService;
    FormulaService formulaService;

    // Dependency Injection
    @Autowired
    public UserController(UserService userService, FormulaService formulaService) {
        this.userService = userService;
        this.formulaService = formulaService;
    }

    // Method that returns the correct view for the URL /postit
    // This handles the GET request for this URL
    // Notice the `method = RequestMethod.GET` part
    @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public String viewProfileGetView(Model model){

        // Add a new Postit Note to the model for the form
        // If you look at the form in addExercise.jsp, you can see that we
        // reference this attribute there by the name `addExercise`.
        //model.addAttribute("userForm",new User());
        
        User user = userService.findByUsername("tester1");
        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        model.addAttribute("user", user);
        
        BMI BMI = formulaService.BMICalculate(user.getHeight(), user.getWeight());
        model.addAttribute("bmi", BMI);

        // Return the view
        return "Profile";
    }
    
 // Method that receives the POST request on the URL /postit
    // and receives the ModelAttribute("addExercise")
    // That attribute is the attribute that is mapped to the form, so here
    // we can save the postit note because we get the data that was entered
    // into the form.
    // Notice the `method = RequestMethod.POST` part
  @RequestMapping(value = "/viewProfile", method = RequestMethod.POST)
    public String viewProfilePostView(@ModelAttribute("newUser") User newUser,
                                     Model model){

	   User oldUser = userService.findByUsername("tester1");
	   int weight = newUser.getWeight();
	   oldUser.setWeight(weight);
	   userService.save(oldUser);
	   
	   User updatedUser = userService.findByUsername("tester1");
	   model.addAttribute("user", updatedUser);
	   BMI BMI = formulaService.BMICalculate(updatedUser.getHeight(), updatedUser.getWeight());
	   model.addAttribute("bmi", BMI);
        // Add a new Postit Note to the model for the form
        // If you look at the form in addExercise.jsp, you can see that we
        // reference this attribute there by the name `addExercise`.
        //model.addAttribute("userForm", new User());

        // Return the view
        return "Profile";
    }
    
 // Method that returns the correct view for the URL /postit/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    // This method finds all Postit Notes posted by someone with the requested {name}
    // and returns a list with all those Postit Notes.
    @RequestMapping(value = "/viewProfile/change", method = RequestMethod.GET)
    public String viewProfileChangeView(Model model){

        // Get all Postit Notes with this name and add them to the model
        //model.addAttribute("changeProfile", userService.findByUsername("tester1"));

        // Add a new Postit Note to the model for the form
        // If you look at the form in addExercise.jsp, you can see that we
        // reference this attribute there by the name `addExercise`.
        //model.addAttribute("Form", new Exercise());
    	
    	model.addAttribute("newUser", new User());

        // Return the view
        return "ProfileChange";
    }

}
