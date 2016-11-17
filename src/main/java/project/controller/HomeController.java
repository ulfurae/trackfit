package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.service.Implementation.UserServiceImplementation;
import project.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){

        User loggedInUser = UserServiceImplementation.loggedInUser;

       if(loggedInUser == null) {
           return "redirect:/login";
       } else {
           model.addAttribute("user",loggedInUser.getUsername());
           return "Index";
       }





    }


}
