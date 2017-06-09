import model.Group;
import model.Student;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Student student = new Student();
        Group group = new Group();

        student.setFirstName("Ivan");
        student.setSecondName("Ivanov");
        student.setLastName("Ivanovich");
        student.setGroupId(121);
        student.setDateOfEnrollment("16.08.1997");

        group.setFacultity("CSIT");
        group.setId(121);
        group.addStudent(student);

        System.out.println(group);
    }
}
