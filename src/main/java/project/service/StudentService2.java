package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.*;
import project.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService2 {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void removeStudent(Integer id) {
        studentRepository.delete(id);
    }

    @Transactional
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Transactional
    public List<Student> getAllStudentsFromSpecifiedGroup(Group group) {
        List<Student> students = group.getStudents();
 //       System.out.println("get students from single group " + students);
        return students;
    }

    @Transactional
    public void editStudent(Student student) {
        Student existingStudent = studentRepository.findOne(student.getId());

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setSecondName(student.getSecondName());
        existingStudent.setDateOfEnrollment(student.getDateOfEnrollment());

        studentRepository.save(existingStudent);
    }

    @Transactional
    public Student getSingleStudentById(Integer id) {
        Student student = studentRepository.findOne(id);
 //       System.out.println("student that shoul be removed: " + student);
        return student;
    }

    @Transactional
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void saveTempStudent(Group group) {
        Student temp = new Student();
        temp.setGroup(group);
     //   temp.setPersonType("Student");
        temp.setId(4);
        temp.setFirstName("iv");
        temp.setLastName("ivv");
        temp.setSecondName("iva");
        System.out.println(temp);
        studentRepository.save(temp);
    }
}
