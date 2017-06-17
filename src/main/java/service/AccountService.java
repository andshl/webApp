package service;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import repository.PersonRepository;

/**
 * @author VYZH
 * @since 16.06.2017
 */
@Service
public class AccountService {

    @Autowired
    private PersonRepository personRepository;

    public Person login(String lastName, String password) {
        Person person = personRepository.findByLastName(lastName);
        Assert.notNull(person, "User with specified name does't exists!");
        // TODO: check password
        return person;
    }
}
