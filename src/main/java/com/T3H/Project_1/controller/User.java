package com.T3H.Project_1.controller;

import com.T3H.Project_1.model.UserDTO;
import com.T3H.Project_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class User {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest req, @RequestParam(name = "e", required = false) String error) {
        if(error != null) req.setAttribute("e", error);
        return "login";
    }

    @GetMapping("/register")
    public String register(HttpServletRequest req, @RequestParam(name = "e", required = false) String erorr) {
        if(erorr != null) req.setAttribute("e", erorr);
        return "register";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest req, @ModelAttribute(name = "user") UserDTO userDTO) {
        userDTO.setRoles("ROLE_USER");
        userService.addUser(userDTO);
        String e = "success";
        req.setAttribute("e", e);
        return "register";
    }

}
