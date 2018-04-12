package it.nextre.prova1.service;

import it.nextre.prova1.entities.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {
    List<User> email=new ArrayList<>();
    public  List<User> getAllEmail(){
        return email;
    }
    public void addEmail(User e){
        email.add(e);
    }
}
