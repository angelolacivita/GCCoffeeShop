package com.test.controller;

/**
 * Created by angelo on 7/21/17.
 */

import com.test.models.ItemsEntity;
import com.test.models.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

@Controller
public class HomeController {

    //JSP page access
    @RequestMapping("/registration")
    //the String method returns the jsp page that we want to show
    public String registration() {

        return "registration";
    }

    @RequestMapping("/items")
    //the String method returns the jsp page that we want to show
    public String items() {

        return "items";
    }

    @RequestMapping("/additem")
    //the String method returns the jsp page that we want to show
    public String additem() {

        return "additem";
    }

    @RequestMapping("/itemeditor")
    //the String method returns the jsp page that we want to show
    public String itemeditor() {

        return "itemeditor";
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
                              @RequestParam("preferences") String preferences) {

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


    @RequestMapping("/listItems")
    public ModelAndView listItems() {
        ArrayList<ItemsEntity> itemsList = getAllItems();
        return new
                ModelAndView("items", "cList", itemsList);

    }

    //this method was extracted to be used again, regular method and not a controller
    private ArrayList<ItemsEntity> getAllItems() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session selectItems = sessionFact.openSession();
        selectItems.beginTransaction();
        Criteria c = selectItems.createCriteria(ItemsEntity.class);
        return (ArrayList<ItemsEntity>) c.list();
    }

    @RequestMapping("/addNewItem")
    public String addNewItem(Model model,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("quantity") String quantity,
                             @RequestParam("price") String price) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session session = sessionFact.openSession();
        Transaction tx = session.beginTransaction();

        ItemsEntity newItem = new ItemsEntity();

        newItem.setName(name);
        newItem.setDescription(description);
        newItem.setQuantity(quantity);
        newItem.setPrice(price);


        session.save(newItem);
        tx.commit();
        session.close();


        ArrayList<ItemsEntity> itemsList = getAllItems();
        model.addAttribute("cList", itemsList);

        return "items";
    }

    @RequestMapping("/delete")
    public ModelAndView deleteItem(@RequestParam("itemid") int itemid) {
        //temporary object will store info for the object we want to delete
        ItemsEntity temp = new ItemsEntity();
        temp.setItemid(itemid);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session items = sessionFact.openSession();
        items.beginTransaction();
        items.delete(temp); //delete teh object from the list
        items.getTransaction().commit();//delete the row from the database table
        ArrayList<ItemsEntity> itemsList = getAllItems();
        return new ModelAndView("items", "cList", itemsList);
    }

    private int itemid;
@RequestMapping("/updateItem")
public String update(int itemid){
        this.itemid = itemid;
        return "itemeditor";
}

    @RequestMapping("/editItem")
    public String editItem(Model model,
                           @RequestParam("name") String name,
                           @RequestParam("description") String description,
                           @RequestParam("quantity") String quantity,
                           @RequestParam("price") String price) {


        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session session = sessionFact.openSession();
        session.beginTransaction();
        ItemsEntity temp = (ItemsEntity) session.get(ItemsEntity.class, itemid);


        temp.setName(name);
        temp.setDescription(description);
        temp.setQuantity(quantity);
        temp.setPrice(price);


        session.update(temp);
        session.getTransaction().commit();
        session.close();


        ArrayList<ItemsEntity> itemsList = getAllItems();
        model.addAttribute("cList", itemsList);

        return "items";

    }


    @RequestMapping("/")

    public ModelAndView helloWorld(String firstName) {
        return new
                ModelAndView("index", "hello", firstName);

    }
}