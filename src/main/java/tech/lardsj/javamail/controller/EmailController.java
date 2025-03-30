package tech.lardsj.javamail.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.*;
import tech.lardsj.javamail.entities.Email;
import tech.lardsj.javamail.entities.EmailDto;
import tech.lardsj.javamail.services.EmailService;

import java.util.List;

@Data
@RestController
@RequestMapping("email")
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public void sendEmail(@RequestBody EmailDto email) {
        this.emailService.sendEmail(email);
    }

    @GetMapping
    public List<Email> getAllEmails() {
        return this.emailService.getEmailRepository().findAll();
    }
}
