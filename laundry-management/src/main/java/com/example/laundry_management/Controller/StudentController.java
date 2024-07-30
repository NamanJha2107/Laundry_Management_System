package com.example.laundry_management.Controller;

import com.example.laundry_management.Entity.Student;
import com.example.laundry_management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/floor/{floor}")
    public List<Student> getStudentsByFloor(@PathVariable int floor) {
        return studentService.getStudentsByFloor(floor);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
