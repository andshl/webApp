package controller;

import model.Group;
import model.Person;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.AccountService;
import service.GroupService;

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

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@RequestParam String lastName, @RequestParam String password) {
        Person person = accountService.login(lastName, password);
        return new ModelAndView("home")
                .addObject("person", person);
    }

    @PostMapping("/add_student")
    public String addStudent(@RequestParam Group group, @RequestParam Student student) {
        groupService.addStudentToGroup(group, student);
        return "home";
    }
}
