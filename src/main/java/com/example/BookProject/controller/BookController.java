package com.example.BookProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {



    @GetMapping("/books")
    public String book(@RequestParam (name = "name", required = false, defaultValue = "Book name") String name,
                       Model model){
        model.addAttribute("name",name);

        return "books";
    }
}
