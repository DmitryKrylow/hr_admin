package com.example.hr_admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
@org.springframework.stereotype.Controller
@RequestMapping("/hr")
public class Controller {

    BookRepos usersRepos;

    public Controller(BookRepos bookRepos){
        this.usersRepos = bookRepos;
    }

    @GetMapping("/login")
    public String login(@RequestParam String name, @RequestParam String key, HttpServletRequest request){
        if(name != null && key != null) {
            if (name.hashCode() == 103149417 && key.hashCode() == -306700301) {
                return "redirect:" + request.getRequestURL().substring(0,request.getRequestURL().indexOf("/login")) + "/allUser";
            }
        }
        return "redirect:" + request.getRequestURL().substring(0,request.getRequestURL().indexOf("/hr"));
    }

    @GetMapping("/deleteAll")
    public String delete(@RequestParam String pass, HttpServletRequest request){
        if(pass.hashCode() == 92668751){
          usersRepos.deleteAll();
        }
        System.out.println(request.getRequestURL());
        return "redirect:" + request.getRequestURL().substring(0,request.getRequestURL().indexOf("/deleteAll")) + "/allUser";
    }
    @GetMapping("/addUser")
    public void add(@RequestParam String pr1){
        addUser(pr1.split("\\|"));
    }
    public void addUser(String[] parameters){
        long id = Long.parseLong(parameters[0]);
        List<User> users = usersRepos.findAllById(id);
        if(users.size() > 0){
            usersRepos.delete(users.get(0));
            usersRepos.save(new User(parameters));
        }else{
            usersRepos.save(new User(parameters));
        }
    }
    @GetMapping("/allUser")
    public String show(Model model){
        model.addAttribute("users", usersRepos.findAll());
        return "users";

    }
}
