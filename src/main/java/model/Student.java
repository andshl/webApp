package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "Student")
@Table(name = "STUDENTS")
public class Student extends Person {
    @Column(name = "GROUP_NUMBER")
    private Integer groupNumber;

    @Column(name = "FACULTITY")
    private Integer facultity;

    @Column(name = "DATE_OF_ENROLLMENT")
    private Date dateOfEnrollment;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");

    public Student() {}

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Date getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(String date) throws ParseException {
        this.dateOfEnrollment = simpleDateFormat.parse(date);
    }

    @Override
    public String toString() {
        return "\tStudent: " +
                this.getSecondName() + " " +
                this.getFirstName() + " " +
                this.getLastName() + " from " +
                this.groupNumber + " group enrolled on " +
                simpleDateFormat.format(this.dateOfEnrollment) + "\r\n";
    }

    public Integer getFacultity() {
        return facultity;
    }

    public void setFacultity(Integer facultity) {
        this.facultity = facultity;
    }
}
