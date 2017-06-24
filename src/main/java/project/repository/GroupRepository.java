package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.model.Group;

public interface GroupRepository extends CrudRepository<Group, String>{
}
