package com.pluma.help.helpdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        // Validação simples
        if("admin".equals(username) && "123".equals(password)) {
            return "redirect:/home";
        }
        return "login"; // Volta para login se inválido
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // precisa existir home.html em /templates
    }
}
