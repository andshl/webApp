package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Student;
import project.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService2 {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void removeStudent(Student student) {
        studentRepository.delete(student);
    }

    @Transactional
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Transactional
    public void editStudent(Student student) {
        Student existingStudent = studentRepository.findOne(student.getId());

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setSecondName(student.getSecondName());
        existingStudent.setDateOfEnrollment(student.getDateOfEnrollment());

        System.out.println("Modified student: " + existingStudent);

        studentRepository.save(existingStudent);
    }

    @Transactional
    public Student getSingleStudentById(Integer id) {
        //System.out.println(studentDAO.getOne(id));
        return studentRepository.findOne(id);
    }
}
