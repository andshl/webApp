package project.repository;

import project.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAll();

    Student getOne(Integer id);

    void remove(Student student);

    void persist(Student student);
}
