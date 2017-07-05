package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.model.Group;
import project.model.Student;
import project.repository.GroupRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Transactional
    public Group getSingleGroupById(Integer id) {
        return groupRepository.findOne(id);
    }

    @Transactional
    public Group getSingleGroupByNumber(Integer number) {
        Group group = groupRepository.findByNumber(number);
 //       System.out.println("group with students which should be removed: " + group);
        return group;
    }

    @Transactional
    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    @Transactional
    public List<Group> getAllGroups() {
        return (List<Group>) groupRepository.findAll();
    }

    @Transactional
    public void editGroup(Group group) {
        Group existingGroup = groupRepository.findOne(group.getId());

        existingGroup.setNumber(group.getNumber());
        existingGroup.setFacultity(group.getFacultity());

        groupRepository.save(existingGroup);
    }

    @Transactional
    public void removeGroup(Integer id) {
        groupRepository.delete(id);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addStudentToGroup(Student student, Integer number) {
        Group group = groupRepository.findByNumber(number);
        group.addStudent(student);
        groupRepository.save(group);
    }

    @Transactional
    public void removeStudentFromGroup(Group group, Student student) {
        System.out.println("in method removeStudentFromGroup. group: " + group);
       // System.out.println("in method removeStudentFromGroup. student: " + student);
        //System.out.println("in method removeStudentFromGroup. student from collection: " + group.getStudents().get(1));
        System.out.println("in method removeStudentFromGroup. student from args: " + student);
        if (group.getStudents().contains(student)) {
            group.getStudents().remove(student);
            System.out.println("student was removed from collection");
        }
        else {
            System.out.println("student was not removed from collection");
        }
        groupRepository.save(group);
    }
}
