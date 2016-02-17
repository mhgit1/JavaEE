/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.controller;


import com.base.DAO.UserDAO;
import com.base.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ohjelmistokehitys
 */
@Controller
public class UserController {
    
    @RequestMapping(value="/admin/user", method=RequestMethod.GET)
    public String renderCourse(ModelMap map){
        map.addAttribute("user", new User());
        try{
            map.addAttribute("courses", UserDAO.getUsers());
        }catch(Exception e){
            e.printStackTrace();
        }
        return "user";
    }
    
    @RequestMapping(value="/admin/user", method=RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user") User usr, ModelMap map){    //mappaa teacher modelattributen teach objektille
        System.out.println(usr.getUsername());
        //map.addAttribute("isLogged", true);
        try{
            UserDAO.addUser(usr);
            map.addAttribute("save_info", "User added succesfully!");
            map.addAttribute("users", UserDAO.getUsers());
            
        }catch(Exception e){
            map.addAttribute("save_info", "Database error!");
            e.printStackTrace();
        }
        
        return "user";
    }
}
