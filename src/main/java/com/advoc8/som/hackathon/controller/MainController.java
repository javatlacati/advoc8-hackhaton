package com.advoc8.som.hackathon.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;



@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping("/adduser")
    public String addUser() {
        return "adduser";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "login";
    }
    
    @GetMapping("/profilelist")
    public String getProfileList() {
        return "profile_list";
    }
    
    @GetMapping("/heatmap")
    public String getHeatMap() {
        return "heatmap";
    }
    
    @GetMapping("/singleprofile")
    public String getSingleProfile() {
        return "single_profile";
    }
    
    @GetMapping("/{title}")
    public String hello(Model model, HttpServletRequest req, @PathVariable String title) {
    	log.info("Title : {}", title);
    	model.addAttribute("messages", title);
        return "hello";
    }

    @GetMapping("/403")
    public String error403() {
        return "403";
    }
    
    @GetMapping("/404")
    public String error404() {
        return "404";
    }
}