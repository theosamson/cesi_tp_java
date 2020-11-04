package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/compteCourant") // This means URL's start with /demo (after Application path)
public class CompteCourantController {
    @Autowired
    private CompteCourantRepository compteCourantRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewCompte (@RequestParam Integer numero
            , @RequestParam Integer amount) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        CompteCourant j = new CompteCourant();
        j.setNumero(numero);
        j.setAmount(amount);
        compteCourantRepository.save(j);
        return "Saved compte";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CompteCourant> getAllCompte() {
        // This returns a JSON or XML with the users
        return compteCourantRepository.findAll();
    }
}