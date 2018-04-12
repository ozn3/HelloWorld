package it.nextre.prova1.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length = 50)
    private Long id;

    @Column(length = 50)
    @NotNull(message = "nullo")
    private String name;

    @Column(length = 50)
    private String surname;

    @NotNull(message = "campo vuoto")
    @Column(length = 50)
    private String email;


    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "nullo")
    private Timestamp log;

    @Column(length = 50)
    @NotNull(message = "nullo")
    private String password;

    @Column(length = 4)
    @NotNull(message = "nullo")
    private int active;
}
