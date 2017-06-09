package model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Integer id;
    private String facultity;
    private List<Student> students = new ArrayList<Student>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        sb.append("Facultity: ").append(facultity).append(". Group with id: ").append(id).append(":\r\n");
        for (Student student : students)
            sb.append(student);
        sb.append("\r\n");
        return sb.toString();
    }
}
