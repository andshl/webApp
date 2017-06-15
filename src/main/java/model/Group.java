package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GROUPS")
public class Group {
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
