package io.github.slisowski.todo_app.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SsoController {
    @GetMapping("/logout")
    String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "index";
    }
}
