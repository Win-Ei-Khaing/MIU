package miu.edu.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String greetFromStartPage(){
        return "Welcome to JWT testing by Win";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String greetFromAdminPage(){
        return "Hello, Admin. This is only for you.";
    }
}
