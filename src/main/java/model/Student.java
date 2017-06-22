package model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "Student")
@Table(name = "STUDENTS")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Student extends Person {
    @Column(name = "GROUP_NUMBER")
    private Integer groupNumber = null;

    @Column(name = "FACULTITY")
    private String facultity = null;

    @Column(name = "DATE_OF_ENROLLMENT")
    private String dateOfEnrollment = null;

    public Student() {}

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(String date) {
        this.dateOfEnrollment = date;
    }

    @Override
    public String toString() {
        return "\tStudent: " +
                this.getSecondName() + " " +
                this.getFirstName() + " " +
                this.getLastName() + " from " +
                this.groupNumber + " group enrolled on " +
                this.dateOfEnrollment + "\r\n";
    }

    public String getFacultity() {
        return facultity;
    }

    public void setFacultity(String facultity) {
        this.facultity = facultity;
    }
}
