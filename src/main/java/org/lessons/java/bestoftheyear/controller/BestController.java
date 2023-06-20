package org.lessons.java.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") //a quale rotta rispondono i metodi di questo controller
public class BestController {

    @GetMapping("/template")
    public String template(Model model){
        String name = "Sofia";
        model.addAttribute("name", name);
        return "index";
    }
}
