package project.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONS")
public class Person implements Serializable{

    private static final long serialVersionUID = 123L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName; //Имя

    @Column(name = "SECOND_NAME")
    private String secondName; //Отчество

    @Column(name = "LAST_NAME")
    private String lastName; //Фамилия

    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    // @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private long createdDate;

    @Column(name = "MODIFIED_DATE")
    @LastModifiedDate
    // @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private long modifiedDate;

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Person() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
