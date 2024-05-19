package ma.exemple.emsiCasablanca03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping({"/home","/"})
    public String showHome() {
        return "home";
    }

    @GetMapping("/hello")
    public String showHello() {
        return "hello";
    }

    @GetMapping("/login")
    public String showLogin() {return "login";}

    @GetMapping("/StudentsChannel")
    public String showStudentChannel() {
        return "studentsChannel";
    }
}
