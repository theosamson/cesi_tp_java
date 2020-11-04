package com.example.demo.compteEpargne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/compteEpargne") // This means URL's start with /demo (after Application path)
public class CompteEpargneController {
    @Autowired
    private CompteEpargneRepository compteEpargneRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewCompteEpargne (
            @RequestParam String numero,
            @RequestParam String intitule,
            @RequestParam Double solde,
            @RequestParam Double tauxInteret) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        CompteEpargne n = new CompteEpargne();
        n.setNumero(numero);
        n.setIntitule(intitule);
        n.setSolde(solde);
        n.setTauxInteret(tauxInteret);
        compteEpargneRepository.save(n);
        return "Saved compte epargne";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<CompteEpargne> getAllCompteEpargne() {
        // This returns a JSON or XML with the users
        return compteEpargneRepository.findAll();
    }
}