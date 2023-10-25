package com.individual.rest;

import com.individual.entity.Individual;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


        // check if the individual be en the list size
        if (id>=theIndividual.size() || id<0 ){
                throw new IndividualNotFoundException("Individual id not found - "+id);
        }
        return theIndividual.get(id);

    }
    // Add an exception handler using @ExceptionHandler


    //Help to catch error and show the error en the browser  ExceptionHandler*//////


    @ExceptionHandler
    public ResponseEntity<IndividualErrorResponse> handleException (IndividualNotFoundException exc){
        // create a StudentErrorResponse

        IndividualErrorResponse error =new IndividualErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler .. to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<IndividualErrorResponse> handleException (Exception exc){
        // create a StudentErrorResponse

        IndividualErrorResponse error =new IndividualErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}


















