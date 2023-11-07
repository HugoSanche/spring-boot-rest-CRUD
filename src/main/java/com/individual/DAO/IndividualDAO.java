package com.individual.DAO;

import com.individual.entity.Individual;

import java.util.List;

public interface IndividualDAO {
    List<Individual> findAll();

    Individual findById(int theId);
    Individual save(Individual theIndividual);

    void deletedById(int theId);
}
