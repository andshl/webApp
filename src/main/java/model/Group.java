package model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GROUPS")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NUMBER")
    private Integer number = null;

    @Id
    @Column(name = "FACULTITY")
    private String facultity = null;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "FACULTITY", referencedColumnName = "FACULTITY"),
            @JoinColumn(name = "GROUP_NUMBER", referencedColumnName = "NUMBER")
    })
    private List<Student> students = new ArrayList<Student>(null);

    @Column(name = "DATE_OF_FIRST_ENROLLMENT")
    private String dateOfFirstEnrollment = null;

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

    public String getDateOfFirstEnrollment() {
        return dateOfFirstEnrollment;
    }

    public void setDateOfFirstEnrollment(String dateOfFirstEnrollment) {
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
