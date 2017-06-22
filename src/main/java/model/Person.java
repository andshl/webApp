package model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERSON_TYPE")
@Table(name = "PERSONS")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Person {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id = null;

    @Column(name = "FIRST_NAME")
    private String firstName = null; //Имя

    @Column(name = "SECOND_NAME")
    private String secondName = null; //Отчество

    @Column(name = "LAST_NAME")
    private String lastName = null; //Фамилия

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
