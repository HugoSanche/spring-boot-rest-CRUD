package com.individual.DAO;

import com.individual.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "members")
public interface IndividualRepository extends JpaRepository<Individual,Integer> {
    // automatically you have all method:
    //findAll()
    //findById()
    //save
    //deleteById()
}
