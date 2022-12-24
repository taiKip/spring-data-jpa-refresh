package com.tarus.springdatajpatutorial.repository;

import com.tarus.springdatajpatutorial.entity.Guardian;
import com.tarus.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student =Student.builder()
                .emailId("victor@gmail.com")
                .firstName("victor")
                .lastName("tarus")
              //  .guardianName("tai")
              //  .guardianEmail("tai@gmail.com")
              //  .guardianMobile("1235323432")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("tai")
                .mobile("23345243")
                .email("tai@gmail.com").build();
        Student student = Student.builder()
                .firstName("vic")
                .emailId("vic@gmail.com")
                .lastName("kip")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public  void fetchAllStudents(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("StudentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
    List<Student> students =
    studentRepository.findByFirstName("victor");
        System.out.println("Students = " + students);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("ic");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("tai");
        System.out.println("Students = " + students);
    }

    @Test
    public  void printStudentsByFirstNameAndLastName(){
        List<Student> students =
                studentRepository.findByFirstNameAndLastName("vic","kip");

        System.out.println("Students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("vic@gmail.com");

        System.out.println("Student =" + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("victor@gmail.com");

        System.out.println("Student : "+ firstName);
    }

    @Test
    public void printGetStudentByEmailAddressQuery(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("vic@gmail.com");
        System.out.println("Student : " + student);
    }
}