package com.individual.service;

import com.individual.DAO.IndividualDAO;
import com.individual.entity.Individual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IndividualServiceImpl implements IndividualService{

    private IndividualDAO individualDAO;

    @Autowired
    public IndividualServiceImpl(IndividualDAO individualDAO) {
        this.individualDAO = individualDAO;
    }

    @Override
    public List<Individual> findAll() {
        return individualDAO.findAll();
    }

    @Override
    public Individual findById(int theId) {
        return individualDAO.findById(theId);
    }

    @Transactional
    @Override
    public Individual save(Individual theIndividual) {
        return individualDAO.save(theIndividual);
    }

    @Transactional
    @Override
    public void deletedById(int theId) {
        individualDAO.deletedById(theId);
    }
}
