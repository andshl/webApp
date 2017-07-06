package project.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENTS")
public class Student extends Person implements Serializable {

    private static final long serialVersionUID = 12L;

    @Column(name = "DATE_OF_ENROLLMENT")
    private String dateOfEnrollment;

    @ManyToOne
    @JoinColumn(name = "group_ID")
    private Group group;

    public Student() {
    }

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
                this.getId() + " " +
                this.getSecondName() + " " +
                this.getFirstName() + " " +
                this.getLastName() + " enrolled  on " +
                this.getDateOfEnrollment() + "\r\n";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (object == null)
            return false;
        if (object.getClass() != this.getClass())
            return false;
        Student other = (Student) object;
        return ((other.getDateOfEnrollment().equals(this.getDateOfEnrollment())) &&
                (other.getFirstName().equals(this.getFirstName())) &&
                (other.getSecondName().equals(this.getSecondName())) &&
                (other.getLastName().equals(this.getLastName())) &&
                (other.getId().equals(this.getId())));

    }
}
