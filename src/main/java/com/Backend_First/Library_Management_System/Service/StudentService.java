package com.Backend_First.Library_Management_System.Service;

import com.Backend_First.Library_Management_System.Entity.LibraryCard;
import com.Backend_First.Library_Management_System.Entity.Student;
import com.Backend_First.Library_Management_System.Enum.CardStatus;
import com.Backend_First.Library_Management_System.Repository.StudentRepository;
import com.Backend_First.Library_Management_System.RequestDTO.StudentRequestDto;
import com.Backend_First.Library_Management_System.RequestDTO.StudentUpdateEmailRequest;
import com.Backend_First.Library_Management_System.ResponseDTO.StudentResponseDto;
import com.Backend_First.Library_Management_System.ResponseDTO.StudentUpdateEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

//    public void addStudent(Student student) {
//
//        //set the value of card...
//        LibraryCard card = new LibraryCard();
//
//        card.setCardStatus(CardStatus.ACTIVATED);
//        card.setValidTill("13/03/2027");
//        card.setStudent(student); // here we pass the student class object so that it will automatically allot to the particular student
//        // the above things is for card creation.
//
//        // set the card attribute in student class...
//        student.setCard(card);  // this is for student class that the card is set now it is given to you,
//
//        // it will save the data for the student
//        studentRepository.save(student);
//    }

    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto)
    {
        // create the student object
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.ACTIVATED);
        // set the student to a card
        card.setStudent(student);   // set the card to particular student

        // set the card to a student
        student.setCard(card);      // set the student to a particular card

        Student updatedStudent = studentRepository.save(student);    // it will save both student and card.

        // return the responseDTO
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setAge(updatedStudent.getAge());
        studentResponseDto.setEmail(updatedStudent.getEmail());
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setDepartment(updatedStudent.getDepartment());

        return studentResponseDto;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

//    public List<Student> getStudentByName(String name) {
//        List<Student> l = studentRepository.findAll();
//
//        List<Student> ans = new ArrayList<>();
//
//        for (Student s : l) {
//            if (s.getName().equals(name)) {
//                ans.add(s);
//            }
//        }
//        return ans;
//    }

    public List<Student> getStudentByName(String name)
    {
        return studentRepository.findByName(name);
    }

    public String findStudentByEmail(@RequestParam("email") String email) {
        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }

    public StudentUpdateEmailResponse updateEmail(StudentUpdateEmailRequest studentUpdateEmailRequest)
    {
        Student student  = studentRepository.findById(studentUpdateEmailRequest.getId()).get();

        student.setEmail(studentUpdateEmailRequest.getEmail());

        // save the student with new mail id
        Student updatedStudent = studentRepository.save(student);

        // convert the updated student into response DTO
        StudentUpdateEmailResponse studentUpdateEmailResponse = new StudentUpdateEmailResponse();
        studentUpdateEmailResponse.setId(updatedStudent.getId());
        studentUpdateEmailResponse.setEmail(updatedStudent.getEmail());
        studentUpdateEmailResponse.setName(updatedStudent.getName());

        return studentUpdateEmailResponse;
    }
}
