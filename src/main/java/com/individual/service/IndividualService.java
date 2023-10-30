package com.individual.service;

import com.individual.entity.Individual;

import java.util.List;

public interface IndividualService {
    List<Individual> findAll();
    Individual findById(int theId);
    Individual save(Individual theIndividual);

    void deletedById(int theId);
}
