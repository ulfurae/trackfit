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

@Controller
public class ExerciseController {

    // Instance Variables
    ExerciseService exerciseService;

    // Dependency Injection
    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    // Method that returns the correct view for the URL /postit
    // This handles the GET request for this URL
    // Notice the `method = RequestMethod.GET` part
    @RequestMapping(value = "/addExercise", method = RequestMethod.GET)
    public String addExerciseViewGet(Model model){

        // Add a new Postit Note to the model for the form
        // If you look at the form in addExercise.jsp, you can see that we
        // reference this attribute there by the name `addExercise`.
        model.addAttribute("exerciseForm",new Exercise());

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        //model.addAttribute("exercises", exerciseService.findAllReverseOrder());

        // Return the view
        return "ExerciseAdd";
    }

    // Method that receives the POST request on the URL /postit
    // and receives the ModelAttribute("addExercise")
    // That attribute is the attribute that is mapped to the form, so here
    // we can save the postit note because we get the data that was entered
    // into the form.
    // Notice the `method = RequestMethod.POST` part
    @RequestMapping(value = "/addExercise", method = RequestMethod.POST)
    public String addExerciseViewPost(@ModelAttribute("addExercise") Exercise exercise,
                                     Model model){

        // Save the Postit Note that we received from the form
        exerciseService.save(exercise);

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        //model.addAttribute("exercises", exerciseService.findAllReverseOrder());

        // Add a new Postit Note to the model for the form
        // If you look at the form in addExercise.jsp, you can see that we
        // reference this attribute there by the name `addExercise`.
        model.addAttribute("exerciseForm", new Exercise());

        // Return the view
        return "ExerciseAdd";
    }

    // Method that returns the correct view for the URL /postit/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    // This method finds all Postit Notes posted by someone with the requested {name}
    // and returns a list with all those Postit Notes.
    @RequestMapping(value = "/exercises/{name}", method = RequestMethod.GET)
    public String addExerciseGetNotesFromName(@PathVariable String name,
                                             Model model){

        // Get all Postit Notes with this name and add them to the model
        model.addAttribute("exercises", exerciseService.findByName(name));

        // Add a new Postit Note to the model for the form
        // If you look at the form in addExercise.jsp, you can see that we
        // reference this attribute there by the name `addExercise`.
        model.addAttribute("exerciseForm", new Exercise());

        // Return the view
        return "ExerciseAdd";
    }
    
    @RequestMapping(value = "/viewPerformance", method = RequestMethod.GET)
    public String userExerciseViewGet(Model model){

        // Add a new Postit Note to the model for the form
        // If you look at the form in addExercise.jsp, you can see that we
        // reference this attribute there by the name `addExercise`.
        //model.addAttribute("exerciseForm",new Exercise());

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        model.addAttribute("exercises", exerciseService.findAllReverseOrder());

        // Return the view
        return "HistoryLog";
    }
    
  
}
