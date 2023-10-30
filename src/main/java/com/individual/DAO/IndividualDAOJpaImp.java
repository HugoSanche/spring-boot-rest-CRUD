package com.individual.DAO;

import com.individual.entity.Individual;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IndividualDAOJpaImp implements IndividualDAO{

    private EntityManager entityManager;

    @Autowired
    public IndividualDAOJpaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Individual> findAll() {
        TypedQuery<Individual> employees=entityManager.createQuery("from Individual order by firstName", Individual.class);
        return employees.getResultList();
    }

    @Override
    public Individual findById(int theId) {
       Individual theIndividual=entityManager.find(Individual.class,theId);

       return theIndividual;
    }

    //NOTE:We don't use @Trasactional at DAO layer It will be handled al service layer

    @Override
    public Individual save(Individual theIndividual) {

        //if id ==0 then insert/save else updated
        Individual dbIndividual=entityManager.merge(theIndividual);
        return entityManager.merge(dbIndividual);
    }

    @Override
    public void deletedById(int theId) {
        //find Individual by id
        Individual theIndividual=entityManager.find(Individual.class,theId);
        entityManager.remove(theIndividual);
    }
}
