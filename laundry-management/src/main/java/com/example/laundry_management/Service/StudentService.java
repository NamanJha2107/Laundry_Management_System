package com.example.laundry_management.Service;

import com.example.laundry_management.Entity.Student;
import com.example.laundry_management.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentsByFloor(int floor) {
        return studentRepository.findByFloor(floor);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
