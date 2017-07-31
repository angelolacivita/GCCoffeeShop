package com.test.controller;

/**
 * Created by angelo on 7/21/17.
 */

import com.test.models.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

@Controller
public class HomeController {


    @RequestMapping("/registration")
    //the String method returns the jsp page that we want to show
    public String registration() {

        return "registration";
    }

    //model is a parameter that allows us to add things to our jsp
    //request param allow us to take in data from the form we must assign a type and a variable with it
    @RequestMapping("/registerUser")
        public String formSuccess(Model model,
                                  @RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName,
                                  @RequestParam("email") String email,
                                  @RequestParam("phoneNumber") String phoneNumber,
                                  @RequestParam("password") String password,
                                  @RequestParam("gender") String gender,
                                  @RequestParam("emailList") String emailList,
                                  @RequestParam("preferences") String preferences){

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();

        UsersEntity newUser = new UsersEntity();

        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setPassword(password);
        newUser.setGender(gender);
        newUser.setEmailList(emailList);
        newUser.setPreferences(preferences);

        session.save(newUser);
        tx.commit();
        session.close();

        model.addAttribute("newStuff", newUser);
        return "summary";
    }
    @RequestMapping("/")

    public ModelAndView helloWorld(String firstName) {
        return new
                ModelAndView("index", "hello", firstName);

    }
}