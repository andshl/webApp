package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import project.model.Student;
import project.service.StudentService2;

import java.util.List;

/**
 * @author VYZH
 * @since 16.06.2017
 */
@Controller
public class IndexController {

    @Autowired
    private StudentService2 studentService;

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

    @RequestMapping("edit/{studentId}")
    public ModelAndView editStudent(@PathVariable("studentId") Integer studentId) {
        ModelAndView mdv = new ModelAndView();
        Student student = studentService.getSingleStudentById(studentId);
        mdv.addObject("student", student);
        mdv.setViewName("edit");
        return mdv;
    }

    @RequestMapping(value = "save/{studentId}", method = RequestMethod.POST)
    public String saveStudent(@PathVariable("studentId") Integer studentId, Student student, BindingResult result) {
        studentService.editStudent(student);

        return "redirect:/home";
    }
}
