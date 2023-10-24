package com.individual.rest;

import com.individual.entity.Individual;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IndividualRestController {
    List<Individual> theIndividual=new ArrayList<>();
    @PostConstruct
    public void postConstructor() throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");

        theIndividual=new ArrayList<>();
        theIndividual.add(new Individual("Hugo","Baltazar","Sanchez","soltero",
                format.parse("07/08/2000"),"Mexicana"));
        theIndividual.add(new Individual("Veronica","Perez","Sanchez","casada",
                format.parse("07/08/1986"),"Mexicana"));
        theIndividual.add(new Individual("Alberto","Martinez","Lopez","casado",
                format.parse("07/08/1975"),"Mexicana"));
    }

    @GetMapping("/individual")
    public List<Individual> getIndividual()  {
        return theIndividual;
    }
    @GetMapping("individual/{id}")
    public Individual getTheIndividualbyID(@PathVariable int id){
        return theIndividual.get(id);
    }
}
