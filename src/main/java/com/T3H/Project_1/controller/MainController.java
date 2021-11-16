package com.T3H.Project_1.controller;

import com.T3H.Project_1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Autowired
    ProductService productService;

    @GetMapping("/hi")
    public String homePage(HttpServletRequest req, @RequestParam(name = "e", required = false) String error, Model model) {
        if(error != null) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            req.setAttribute("e", error);
            req.setAttribute("username", userDetails.getUsername());
        }
        req.setAttribute("products", productService.getAllProducts());
        return "index";
    }

}
