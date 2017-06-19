package service;

import model.Person;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PersonRepository;

/**
 * @author VYZH
 * @since 16.06.2017
 */
@Service
public class InitialDataPopulator implements InitializingBean {

    @Autowired
    private PersonRepository personRepository;

    public void afterPropertiesSet() throws Exception {
        Person admin = new Person();
        admin.setLastName("admin");
        personRepository.save(admin);
    }
}
