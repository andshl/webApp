package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "GROUPS")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NUMBER")
    private Integer number;

    @Id
    @Column(name = "FACULTITY")
    private String facultity;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "FACULTITY", referencedColumnName = "FACULTITY"),
            @JoinColumn(name = "GROUP_NUMBER", referencedColumnName = "NUMBER")
    })
    private List<Student> students = new ArrayList<Student>();

    @Column(name = "DATE_OF_FIRST_ENROLLMENT")
    private Date dateOfFirstEnrollment;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getFacultity() {
        return facultity;
    }

    public void setFacultity(String facultity) {
        this.facultity = facultity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    public Date getDateOfFirstEnrollment() {
        return dateOfFirstEnrollment;
    }

    public void setDateOfFirstEnrollment(Date dateOfFirstEnrollment) {
        this.dateOfFirstEnrollment = dateOfFirstEnrollment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Facultity: ").append(facultity).append(". Group with number: ").append(number).append(":\r\n");
        for (Student student : students)
            sb.append(student);
        sb.append("\r\n");
        return sb.toString();
    }
}
