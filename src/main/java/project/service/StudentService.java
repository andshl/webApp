package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Group;
import project.model.Student;
import project.repository.StudentRepository;

import java.text.ParseException;
import java.util.List;

@Service
public class StudentService {
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
        return students;
    }

    @Transactional
    public void editStudent(Student student) throws ParseException {
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
        return student;
    }

    @Transactional
    public void addStudent(Student student) {
        studentRepository.save(student);
    }
}
