package tech.lardsj.javamail.services;

import lombok.Data;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tech.lardsj.javamail.entities.Email;
import tech.lardsj.javamail.entities.EmailDto;
import tech.lardsj.javamail.repositories.EmailRepository;

import java.util.UUID;

@Data
@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;

    public void sendEmail(EmailDto emailDto) {
        var message =  new SimpleMailMessage();

        message.setFrom("noreply@lardsj.com");
        message.setTo(emailDto.to());
        message.setSubject(emailDto.subject());
        message.setText(emailDto.body());
        javaMailSender.send(message);

        var email = new Email(
                UUID.randomUUID(),
                emailDto.to(),
                emailDto.subject(),
                emailDto.body()
        );
        this.emailRepository.save(email);
    }

}
