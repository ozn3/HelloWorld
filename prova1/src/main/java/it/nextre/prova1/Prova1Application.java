package it.nextre.prova1;

import it.nextre.prova1.Repository.UserRepository;
import it.nextre.prova1.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class Prova1Application {

    @Autowired
    UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Prova1Application.class, args);
	}

	/*@Override
    public void run(String... strings)throws Exception{
        User em=new User();
        em.setEmail("email");
        em.setName("nome");
        em.setSurname("cognome");
        em.setPassword("password");
        em.setActive(1);
        em.setLog(new java.sql.Timestamp(LocalDate.now().toEpochDay()));
        userRepository.save(em);
    }*/
}
