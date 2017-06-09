package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {
    private Integer groupId;
    private Date dateOfEnrollment;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");

    public Student() {}

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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
                this.groupId + " group enrolled on " +
                simpleDateFormat.format(this.dateOfEnrollment) + "\r\n";
    }
}
