package project.repository;

import project.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VYZH
 * @since 16.06.2017
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findByLastName(String lastName);
}
