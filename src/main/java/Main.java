import model.Group;
import model.Student;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Student student = new Student();
        Group group = new Group();

        student.setFirstName("Ivan");
        student.setSecondName("Ivanovich");
        student.setLastName("Ivanov");
        student.setGroupNumber(121);
        student.setDateOfEnrollment("16.08.1997");

        group.setFacultity("CSIT");
        group.setNumber(121);
        group.addStudent(student);

        System.out.println(group);
    }
}
