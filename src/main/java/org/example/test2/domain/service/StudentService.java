package org.example.test2.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.test2.application.dto.request.CreateStudentDto;
import org.example.test2.application.dto.response.StudentDto;
import org.example.test2.domain.entity.Student;
import org.example.test2.external.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public ResponseEntity<StudentDto> getStudent(int id) {
        StudentDto studentDto = new StudentDto();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentDto.setId(student.getId());
            studentDto.setName(student.getName());
            studentDto.setGrade(student.getGrade());
            return ResponseEntity.ok(studentDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Student> addStudent(CreateStudentDto createStudentDto) {
        Student student = new Student();
        student.setName(createStudentDto.getName());
        student.setEmail(createStudentDto.getEmail());
        student.setAddress(createStudentDto.getAddress());
        student.setGrade(createStudentDto.getGrade());
        studentRepository.save(student);
        return ResponseEntity.ok(student);
    }

    public ResponseEntity<String> deleteStudent(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("student deleted");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> updateStudent(int id, String name) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            log.info("student found and the id is " + id);
            Student student = optionalStudent.get();
            student.setName(name);
            studentRepository.save(student);
            return ResponseEntity.ok("updated");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
