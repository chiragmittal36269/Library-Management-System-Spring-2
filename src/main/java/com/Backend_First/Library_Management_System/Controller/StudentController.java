package com.Backend_First.Library_Management_System.Controller;

import com.Backend_First.Library_Management_System.Entity.Student;
import com.Backend_First.Library_Management_System.RequestDTO.StudentRequestDto;
import com.Backend_First.Library_Management_System.RequestDTO.StudentUpdateEmailRequest;
import com.Backend_First.Library_Management_System.ResponseDTO.StudentResponseDto;
import com.Backend_First.Library_Management_System.ResponseDTO.StudentUpdateEmailResponse;
import com.Backend_First.Library_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

//    @PostMapping("/add")
//    public String addStudent(@RequestBody Student student) {
//        studentService.addStudent(student);
//        return "Student has been added successfully";
//    }

    @PostMapping("/add")
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/get_students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/get_student")
    public List<Student> getStudentByName(@RequestParam("name") String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/find_by_email")
    public String findStudentByEmail(@RequestParam("email") String email) {
        return studentService.findStudentByEmail(email);
    }

    @PutMapping("/update_email")
    public StudentUpdateEmailResponse updateEmail(@RequestBody StudentUpdateEmailRequest studentUpdateEmailRequest)
    {
        return studentService.updateEmail(studentUpdateEmailRequest);
    }
}
