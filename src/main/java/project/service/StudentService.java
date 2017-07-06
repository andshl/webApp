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
    public List<Student> getAllStudentsFromSpecifiedGroup(Group group) {
        return group.getStudents();
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
        return studentRepository.findOne(id);
    }
}
