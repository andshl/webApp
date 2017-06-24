package project.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Student")
@Table(name = "STUDENTS")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Student extends Person {

    @Column(name = "DATE_OF_ENROLLMENT")
    private String dateOfEnrollment = null;

    @ManyToOne
    private Group group;

    public Student() {}

    public String getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(String date) {
        this.dateOfEnrollment = date;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "\tStudent: " +
                this.getSecondName() + " " +
                this.getFirstName() + " " +
                this.getLastName() + " enrolled on " +
                this.dateOfEnrollment + "\r\n";
    }
}
