package com.individual.service;

import com.individual.DAO.IndividualRepository;
import com.individual.entity.Individual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndividualServiceImpl implements IndividualService {

    private IndividualRepository individualRepository;

    @Autowired
    public IndividualServiceImpl(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }

    @Override
    public List<Individual> findAll() {
        return individualRepository.findAll();
    }

    @Override
    public void deleteById(int theId) {
        individualRepository.deleteById(theId);
    }

    @Override
    public Individual findById(int theId) {
        Optional<Individual> result=individualRepository.findById(theId);

        Individual theIndividual=null;
        if (result.isPresent()){
            theIndividual=result.get();
        }else{
            throw new RuntimeException("The id for the individual does not exist "+theId);
        }
        return theIndividual;
    }

    @Override
    public Individual save(Individual theIndividual) {
        return individualRepository.save(theIndividual);
    }



}













