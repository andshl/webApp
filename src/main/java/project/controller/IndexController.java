package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.model.Group;
import project.model.Student;
import project.service.AccountService;
import project.service.GroupService;
import project.service.StudentService;

import java.util.List;

/**
 * @author VYZH
 * @since 16.06.2017
 */
@Controller
public class IndexController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StudentService studentService;

//    @RequestMapping(value = "/login" , method = RequestMethod.GET)
//    public ModelAndView login(){
//        ModelAndView mdv = new ModelAndView();
//        mdv.setViewName("login");
//        return mdv;
//    }

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public ModelAndView showHome() {
        ModelAndView mdv = new ModelAndView();
        List<Student> students = studentService.getAllStudents();
        mdv.addObject("students", students);
        mdv.setViewName("home");
        return mdv;
    }

    @RequestMapping("/delete/{studentId}")
    public String deleteEntity(@PathVariable("studentId") Integer studentId) {
        Student student = studentService.getSingleStudentById(studentId);
        studentService.removeStudent(student);
        return "home";
    }


    @PostMapping("/add_student")
    public String addStudent(@RequestParam Group group, @RequestParam Student student) {
        groupService.addStudentToGroup(group, student);
        return "home";
    }
}
