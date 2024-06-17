package org.example.test2.application.controllers;

import lombok.AllArgsConstructor;
import org.example.test2.application.dto.request.CreateStudentDto;
import org.example.test2.application.dto.response.StudentDto;
import org.example.test2.domain.entity.Student;
import org.example.test2.domain.service.StudentService;
import org.example.test2.external.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "api/v1/student")
@RestController
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity<StudentDto> getStudent(@RequestParam int id) {
        return studentService.getStudent(id);
    }
    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody CreateStudentDto createStudentDto) {
        return studentService.addStudent(createStudentDto);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam int id) {
        return studentService.deleteStudent(id);
    }
    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestParam int id,String name) {
        return studentService.updateStudent(id,name);
    }
}
