package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

//     Spring Boot REST API with Path Variable
//     {id} --> URI template variable
//    http://localhost:8080/students/2
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId, "Ramesh", "Patel");
    }

//    http://localhost:8080/students/2/Aman
    @GetMapping("students/{id}/{first-name}")
    public Student studentPathVariableTwo(@PathVariable("id") int studentId,
                                          @PathVariable("first-name") String firstName){
        return new Student(studentId, firstName, "Patel");
    }

//    Spring Boot REST API with Request Param
//    http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id, "Ramesh", "Patel");
    }

//    Spring Boot REST API with multiple Request Param
//    http://localhost:8080/students/queryy?id=7&firstName=Vibha&lastName=Devi
    @GetMapping("students/queryy")
    public Student studentRequestVariableTwo(@RequestParam int id,
                                             @RequestParam String firstName,
                                             @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }
}
