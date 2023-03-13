package com.Backend_First.Library_Management_System.Service;

import com.Backend_First.Library_Management_System.Entity.LibraryCard;
import com.Backend_First.Library_Management_System.Entity.Student;
import com.Backend_First.Library_Management_System.Enum.CardStatus;
import com.Backend_First.Library_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {

        //set the value of card...
        LibraryCard card = new LibraryCard();

        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("13/03/2027");
        card.setStudent(student); // here we pass the student class object so that it will automatically alloted to the particular student
        // the above things is for card creation.

        // set the card attribute in student class...
        student.setCard(card);  // this is for student class that the card is set now it is given to you

        // it will save the data for the student
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentByName(String name) {
        List<Student> l = studentRepository.findAll();

        List<Student> ans = new ArrayList<>();

        for (Student s : l) {
            if (s.getName().equals(name)) {
                ans.add(s);
            }
        }
        return ans;
    }
}
