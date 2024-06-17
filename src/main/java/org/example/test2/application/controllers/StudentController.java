package org.example.test2.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "api/v1/student")
@RestController
public class StudentController {

    @GetMapping("/getStudent")
    public String getStudent() {
        return "Student";
    }
}
