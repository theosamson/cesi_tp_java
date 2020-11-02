package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/compte") // This means URL's start with /demo (after Application path)
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;

    @PostMapping(path="/addCompte") // Map ONLY POST Requests
    public @ResponseBody String addNewCompte (@RequestParam Integer numero
            , @RequestParam Integer amount) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Compte j = new Compte();
        j.setNumero(numero);
        j.setAmount(amount);
        compteRepository.save(j);
        return "Saved compte";
    }

    @GetMapping(path="/allCompte")
    public @ResponseBody Iterable<Compte> getAllCompte() {
        // This returns a JSON or XML with the users
        return compteRepository.findAll();
    }
}