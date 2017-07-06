package project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
//@EntityListeners(AuditingEntityListener.class)
@Table(name = "GROUPS")
public class Group extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1234L;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "FACULTITY")
    private String facultity;

    @OneToMany(mappedBy = "group", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
        if (student.getGroup() != this)
            student.setGroup(this);
        students.add(student);
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Facultity: ").append(facultity).append(". Group with number: ").append(number).append(".\r\n");
        for (Student student : students)
            sb.append(student);
        sb.append("\r\n");
        return sb.toString();
    }

}
