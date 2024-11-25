package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Aman",
                "Patel"
        );
        return student;
    }

//    http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ramesh", "Patel"));
        students.add(new Student(2, "Aman", "Patel"));
        students.add(new Student(3, "Vibha", "Devi"));
        students.add(new Student(4, "Khusbu", "Kumari"));
        students.add(new Student(5, "Nisha", "Seth"));
        return students;
    }

    // Spring Boot REST API with Path Variable
    // {id} --> URI template variable
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable int id){
        return new Student(id, "Ramesh", "Patel");
    }

}
