package ma.exemple.emsiCasablanca03.controller;

import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/files")
    public String showUploadDownloadPage() {
        return "files";
    }
}


/*

    @GetMapping("/api")
    public String showFiles() {return "files";}


    private void addUserInfoToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());
    }

    */


