package project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.model.Group;
import project.model.Student;
import project.service.GroupService;
import project.service.StudentService;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

@Controller
public class IndexController {

    private static final Logger LOG =
            LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping("/home")
    public ModelAndView showHome(ModelAndView mdv, Principal principal) {
        LOG.info("User {} browsing page /home", principal);
        List<Group> groups = groupService.getAllGroups();
        mdv.addObject("groups", groups);
        mdv.setViewName("home");
        return mdv;
    }

    @RequestMapping(value = "/home/delete", method = RequestMethod.GET)
    public String deleteGroup(@RequestParam(value="id", required = true) Integer groupId) {
        groupService.removeGroup(groupId);
        return "redirect:/home";
    }

    @RequestMapping(value="/home/edit", method=RequestMethod.GET)
    public ModelAndView editGroup(@RequestParam(value="id", required = true) Integer groupId, ModelAndView mdv) {
        Group group = groupService.getSingleGroupById(groupId);
        mdv.getModelMap().addAttribute("group", group);
        mdv.setViewName("edit_group");
        return mdv;
    }

    @RequestMapping(value = "/home/edit", method = RequestMethod.POST)
    public String saveEditGroup(@ModelAttribute("group") Group group, @RequestParam(value = "id", required = true) Integer id) {
        groupService.editGroup(group);
        return "redirect:/home";
    }

    @RequestMapping(value="/home/add", method=RequestMethod.GET)
    public ModelAndView addGroup(ModelAndView mdv) {
        mdv.getModelMap().addAttribute("group", new Group());
        mdv.setViewName("add_group");
        return mdv;
    }

    @RequestMapping(value = "/home/add", method = RequestMethod.POST)
    public String saveAddGroup(@ModelAttribute("group") Group group) {
        groupService.addGroup(group);
        return "redirect:/home";
    }

    @RequestMapping("/home/{number}")
    public ModelAndView showStudentsFromGroup(@PathVariable("number") Integer number,  ModelAndView mdv) {
        Group group = groupService.getSingleGroupByNumber(number);
        List<Student> students = studentService.getAllStudentsFromSpecifiedGroup(group);
        mdv.addObject("students", students);
        mdv.addObject("number", number);
        mdv.setViewName("home_students");
        return mdv;
    }

    @RequestMapping(value = "/home/{number}/delete", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("number") Integer number, @RequestParam(value="id", required = true) Integer studentId) {
        Group group = groupService.getSingleGroupByNumber(number);
        Student student = studentService.getSingleStudentById(studentId);
        groupService.removeStudentFromGroup(group, student);
        return "redirect:/home/{number}";
    }

    @RequestMapping(value="/home/{number}/edit", method=RequestMethod.GET)
    public ModelAndView editStudent(@PathVariable("number") Integer number, @RequestParam(value="id", required = true) Integer studentId, ModelAndView mdv) {
        Student student = studentService.getSingleStudentById(studentId);
        mdv.getModelMap().addAttribute("student", student);
        mdv.addObject("number", number);
        mdv.setViewName("edit_student");
        return mdv;
    }

    @RequestMapping(value = "/home/{number}/edit", method = RequestMethod.POST)
    public String saveEditStudent(@PathVariable("number") Integer number, @ModelAttribute("student") Student student, @RequestParam(value = "id", required = true) Integer id) throws ParseException {
        studentService.editStudent(student);
        return "redirect:/home/{number}";
    }

    @RequestMapping(value="/home/{number}/add", method=RequestMethod.GET)
    public ModelAndView addStudent(@PathVariable("number") Integer number, ModelAndView mdv) {
        Student student = new Student();
        Group group = groupService.getSingleGroupByNumber(number);
        student.setGroup(group);
        mdv.getModelMap().addAttribute("student", student);
        mdv.addObject("number", number);
        mdv.setViewName("add_student");
        return mdv;
    }

    @RequestMapping(value = "/home/{number}/add", method = RequestMethod.POST)
    public String saveAddStudent(@PathVariable("number") Integer number, @ModelAttribute("student") Student student) {
       groupService.addStudentToGroup(student, number);
        return "redirect:/home/{number}";
    }
}
