package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;

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
    public void editStudent(Student student) {
        Student existingStudent = studentRepository.findOne(student.getId());

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setSecondName(student.getSecondName());
        existingStudent.setFacultity(student.getFacultity());
        existingStudent.setGroupNumber(student.getGroupNumber());
        existingStudent.setDateOfEnrollment(student.getDateOfEnrollment());

        studentRepository.save(existingStudent);
    }
}
