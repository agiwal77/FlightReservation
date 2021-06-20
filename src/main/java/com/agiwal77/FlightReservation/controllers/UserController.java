package com.agiwal77.FlightReservation.controllers;

import com.agiwal77.FlightReservation.model.User;
import com.agiwal77.FlightReservation.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/showReg")
    public String showRegistrationPage(){
        return "login/registerUser";
    }

    @RequestMapping("/login")
    public String showLoginPage(){
        return "login/login";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
        User user = userRepository.findByEmail(email);
        if(user.getPassword().equals(password)){
            return "findFlights";
        }else{
            modelMap.addAttribute("error",user.toString());
            return "login/login";
        }
    }
}
