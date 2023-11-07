package com.individual.rest;

import com.individual.entity.Individual;
import com.individual.service.IndividualService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IndividualRestController {


    private IndividualService individualService;

    public IndividualRestController(IndividualService individualService) {
        this.individualService = individualService;
    }

    // Add mapping GET for all individual
    @GetMapping("/individuals")
    public List<Individual> getIndividual()  {
        return individualService.findAll();
    }

    //Add mapping for GET / individual .- Get individual by id

    @GetMapping("/individuals/{individualId}")
    public Individual getIndividualbyID(@PathVariable  int individualId){
        Individual theIndividual=individualService.findById(individualId);

        // check if the individual be en the list size
        if (theIndividual==null){
                throw new IndividualNotFoundException("Individual id not found - "+theIndividual);
        }
        return theIndividual;

    }

    // add mapping for POST / individuals .- Add new individual
    @Transactional
    @PostMapping("/individuals")
    public Individual addIndividual(@RequestBody Individual theIndividual){

        //also just in case they pass an id in JSON  ... set id to 0
        // this is to force a save of new item ... instead of update
        theIndividual.setPerson(0);

        Individual dbIndividual=individualService.save(theIndividual);
        return dbIndividual;

    }
    //add mapping for PUT / individual.- updating existing individual

    @PutMapping("/individuals")
    public Individual updateIndividual(@RequestBody Individual theIndividual){
        Individual dbIndividual=individualService.save(theIndividual);
        return dbIndividual;
    }

    //Add mapping for DELETE  /individuals/{individualId} - delete individual

    @DeleteMapping("/individuals/{individualId}")
    public String deleteIndividual(@PathVariable int individualId){
        Individual dbIndividual=individualService.findById(individualId);

        if (dbIndividual==null){
            throw new RuntimeException("Employee id not found "+individualId);
        }
        individualService.deletedById(individualId);

        return "Deleted individual id "+individualId;
    }


}


















