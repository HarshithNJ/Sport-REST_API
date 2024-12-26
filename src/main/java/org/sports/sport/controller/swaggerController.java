package org.sports.sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class swaggerController {
    
    @GetMapping("/")
    public String swagger() {
        return "redirect:/swagger-ui/index.html";
    }
    
}
