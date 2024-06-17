package org.example.test2.application.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CreateStudentDto {
    private String name;
    private String address;
    private String email;
    private int grade;
}
