package project.service;

import project.model.Group;
import project.model.Student;
import org.springframework.stereotype.Service;

/**
 * @author VYZH
 * @since 16.06.2017
 */
@Service
public class GroupService {

    public Group addStudentToGroup(Group group, Student student) {
        // TODO: add student, re-calculate dateOfFirstEnrollment
        return group;
    }
}
