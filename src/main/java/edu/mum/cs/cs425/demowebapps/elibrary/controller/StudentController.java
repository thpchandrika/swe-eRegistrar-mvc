package edu.mum.cs.cs425.demowebapps.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping(value = {"/eregistrar/students","/eregistrar/student/home"})
    public String displayHomePage() {
        return "student/index";
    }
}
