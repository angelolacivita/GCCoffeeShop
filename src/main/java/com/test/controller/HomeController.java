package com.test.controller;

/**
 * Created by angelo on 7/21/17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @RequestMapping("/registration")
    //the String method returns the jsp page that we want to show
    public String registration() {

        return "registration";
    }

    //model is a parameter that allows us to add things to our jsp
    //request param allow us to take in data from the form we must assign a type and a variable with it
    @RequestMapping("/summary")
        public String formSuccess(Model model, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
        @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("password") String password,
                                  @RequestParam("gender") String gender, @RequestParam("emailList") String emailList, @RequestParam("preferences") String preferences){
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("password", password);
        model.addAttribute("gender", gender);
        return "summary";
    }
    @RequestMapping("/")

    public ModelAndView helloWorld(String firstName) {
        return new
                ModelAndView("index", "hello", firstName);

    }
}