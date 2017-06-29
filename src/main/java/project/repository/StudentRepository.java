package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
