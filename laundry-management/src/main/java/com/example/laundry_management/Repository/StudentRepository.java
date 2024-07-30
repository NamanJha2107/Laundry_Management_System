package com.example.laundry_management.Repository;

import com.example.laundry_management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFloor(int Floor);
}
