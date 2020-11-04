package com.example.demo.user;

import com.example.demo.compteCourant.CompteCourant;
import com.example.demo.compteEpargne.CompteEpargne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser(
            @RequestParam String identifiant,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam CompteCourant compteCourant,
            @RequestParam CompteEpargne compteEpargne
    ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setIdentifiant(identifiant);
        n.setNom(nom);
        n.setPrenom(prenom);
        n.setCompteCourant(compteCourant);
        n.setCompteEpargne(compteEpargne);
        userRepository.save(n);
        return "Saved User";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody
    void deleteUSer(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
}