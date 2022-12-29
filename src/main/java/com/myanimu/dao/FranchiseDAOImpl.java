package com.myanimu.dao;

import com.myanimu.models.Franchise;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FranchiseDAOImpl implements FranchiseDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Franchise> getFranchises() {
        String query = "FROM Franchise";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeFranchise(int id) {
        Franchise franchise = entityManager.find(Franchise.class, id);
        entityManager.remove(franchise);
    }

    @Override
    public void addFranchise(Franchise franchise) {
        entityManager.merge(franchise);
    }

    @Override
    public Franchise getFranchise(int id) {
        return entityManager.find(Franchise.class, id);
    }

    @Override
    public List<Franchise> getFranchiseByName(String name) {
        String query = "FROM Franchise WHERE name = :name";
        List<Franchise> franchises = entityManager.createQuery(query).setParameter("name", name).getResultList();
        if(franchises.isEmpty()){
            return null;
        }
        return franchises;
    }
}
