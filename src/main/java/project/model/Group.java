package project.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NUMBER")
    private Integer number = null;

    @Column(name = "FACULTITY")
    private String facultity = null;

    @OneToMany(mappedBy = "group", orphanRemoval = true, cascade = CascadeType.ALL)
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
