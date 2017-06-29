package project.repository;

import org.springframework.stereotype.Repository;
import project.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    public List<Student> getAll() {
        return entityManager.createQuery("from Student").getResultList();
    }

    public Student getOne(Integer id) {
       return entityManager.find(Student.class, id);
    }

    public void remove(Student student) {
        entityManager.getTransaction().begin();
        Student studentToBeRemoved = entityManager.contains(student) ? student : entityManager.merge(student);
        entityManager.remove(studentToBeRemoved);
        entityManager.getTransaction().commit();
    }

    public void persist(Student student) {
        entityManager.persist(student);
    }

}
