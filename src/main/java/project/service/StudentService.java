package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Student;
import project.repository.StudentDAO;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public void removeStudent(Student student) {
        studentDAO.remove(student);
    }

    @Transactional
    public List<Student> getAllStudents() {
        return studentDAO.getAll();
    }

    @Transactional
    public void editStudent(Student student) {
        Student existingStudent = studentDAO.getOne(student.getId());

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setSecondName(student.getSecondName());
        existingStudent.setDateOfEnrollment(student.getDateOfEnrollment());

        System.out.println("Modified student: " + existingStudent);

        studentDAO.persist(existingStudent);
    }

    @Transactional
    public Student getSingleStudentById(Integer id) {
        System.out.println(studentDAO.getOne(id));
        return studentDAO.getOne(id);
    }
}
