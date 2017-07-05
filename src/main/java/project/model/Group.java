package project.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "GROUPS")
public class Group implements Serializable {

    private static final long serialVersionUID = 1234L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "FACULTITY")
    private String facultity;

    @OneToMany(mappedBy = "group", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<Student>();

    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(value = TemporalType.DATE)
    //@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    @LastModifiedDate
    @Temporal(value = TemporalType.DATE)
    // @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private Date modifiedDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (student.getGroup() != this)
            student.setGroup(this);
        System.out.println("student to be added " + student);
        students.add(student);
        System.out.println("student was added to collection");
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
