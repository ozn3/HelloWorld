package it.nextre.prova1.controllers;

import com.sun.javaws.Main;
import it.nextre.prova1.Repository.UserRepository;
import it.nextre.prova1.entities.User;
import it.nextre.prova1.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Controller
public class UserController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String getHome(){
        return "index.html";
    }

    @GetMapping("/grazie")
    public String getTest(){
        return "grazieee.html";
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/adduser")
    public String saveEmail(@RequestParam String email,
                            @RequestParam String name,
                            @RequestParam String surname,
                            @RequestParam String password){
        User em=new User();
        em.setEmail(email);
        em.setName(name);
        em.setSurname(surname);
        em.setPassword(password);
        em.setActive(1);
        em.setLog(Timestamp.valueOf(LocalDateTime.now()));
        userRepository.save(em);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam long id){
        User u =userRepository.findOne(id);
        u.setActive(0);
        userRepository.save(u);
        return "redirect:/manage";
    }
    @PostMapping("/edit")
    public String editUser(@RequestParam long id2,
                           @RequestParam String editName,
                           @RequestParam String editSurname,
                           @RequestParam String editMail,
                           @RequestParam String editPassword){
        System.out.println("NAMEMMMMMMMMMMMMMMMMMMM :"+ editName);
        User u =userRepository.findOne(id2);
        if(!editName.equals(""))
            u.setName(editName);
        if(!editSurname.equals(""))
            u.setSurname(editSurname);
        if(!editMail.equals(""))
            u.setEmail(editMail);
        if(!editPassword.equals(""))
            u.setPassword(editPassword);
        userRepository.save(u);
        return "redirect:/manage";
    }

    @RequestMapping("/users")
    public String users(Model m){
        m.addAttribute("listaUsers" , userRepository.findAll());
        return "lista.html";
    }


    @RequestMapping("/")
    public String home(Model m){
        m.addAttribute("message", "Successo");
        return "index.html";
    }

    @RequestMapping("/manage")
    public String manages(Model m){
        m.addAttribute("listaUsers" , userRepository.findAll());
        return "Manage.html";
    }

    @RequestMapping("/deleted")
    public String deletedAccounts(Model m){
        m.addAttribute("listaUsers", userRepository.findAll());
        return "deleted.html";
    }

    @PostMapping("/recover")
    public String recovery(@RequestParam long id){
        User u =userRepository.findOne(id);
        u.setActive(1);
        userRepository.save(u);
        return "redirect:/deleted";
    }


}
