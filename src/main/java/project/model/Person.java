package project.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONS")
public class Person extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 123L;

    @Column(name = "FIRST_NAME")
    private String firstName; //Имя

    @Column(name = "SECOND_NAME")
    private String secondName; //Отчество

    @Column(name = "LAST_NAME")
    private String lastName; //Фамилия

    public Person() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
