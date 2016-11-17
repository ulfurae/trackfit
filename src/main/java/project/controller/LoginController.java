package project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.persistence.entities.User;
import project.security.impl.AuthenticationManagerImpl;
import project.service.Implementation.UserServiceImplementation;
import project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;


    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("login");
        model.addAttribute("regForm", new User());

        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam(value = "username", required = true) String username,
                            @RequestParam(value = "password", required = true) String password) {

        AuthenticationManager authenticationManager = new AuthenticationManagerImpl(userService);

        try {
            Authentication authRequest = new UsernamePasswordAuthenticationToken(username, password);
            Authentication result = authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {
            LOGGER.error("Authentication failed: {}", e);
            return "redirect:/login-failed";
        }

        LOGGER.debug("Successfully authenticated. Security context contains: {}",
                SecurityContextHolder.getContext().getAuthentication());

        userService.getLoggedInUser();

        return "redirect:/";
    }

    @RequestMapping(value = "/login-failed", method = RequestMethod.GET)
    public ModelAndView loginFailedPage(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("loginErrorMessage", "Login failed, please try again.");
        modelAndView.setViewName("login");
        model.addAttribute("regForm", new User());

        return modelAndView;
    }

    @RequestMapping(value = "/process-register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute User user, HttpServletRequest request,
                               HttpServletResponse response) {

        userService.save(user);

        if (user.getId() != null) { // registration is successful
            autoLoginUser(user);
        } else {
            LOGGER.warn("Registration failed for user {}", user.getUsername());
        }

        return "redirect:/";
    }

    private void autoLoginUser(User user) {

        try {
            AuthenticationManager authenticationManager = new AuthenticationManagerImpl(userService);
            Authentication authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPass());
            Authentication result = authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (Exception e) {
            LOGGER.error("Couldn't login the user {} automatically: ", user.getUsername(), e);
            SecurityContextHolder.getContext().setAuthentication(null);
        }

        userService.getLoggedInUser();

    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {

        UserServiceImplementation.loggedInUser = null;

        return "redirect:/";
    }


}
