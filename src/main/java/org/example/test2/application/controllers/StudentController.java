package org.example.test2.application.controllers;

import lombok.AllArgsConstructor;
import org.example.test2.domain.entity.Student;
import org.example.test2.external.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "api/v1/student")
@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/getStudent")
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
}
