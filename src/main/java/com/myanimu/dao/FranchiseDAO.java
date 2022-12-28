package com.myanimu.dao;

import com.myanimu.models.Franchise;

import java.util.List;

public interface FranchiseDAO {
    List<Franchise> getFranchises();
    void removeFranchise(int id);
    void addFranchise(Franchise franchise);
    Franchise getFranchise(int id);
    Franchise getFranchiseByName(String name);
}
