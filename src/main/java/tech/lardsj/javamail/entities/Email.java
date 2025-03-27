package tech.lardsj.javamail.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "email")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name = "email_id")
    private UUID id;
    private String to_destni;
    private String subject;
    private String body;
}
