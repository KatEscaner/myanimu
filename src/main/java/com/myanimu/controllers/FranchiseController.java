package com.myanimu.controllers;

import com.myanimu.dao.FranchiseDAO;
import com.myanimu.models.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FranchiseController {

    @Autowired
    private FranchiseDAO franchiseDao;

    @RequestMapping(value = "api/franchise/{id}", method = RequestMethod.GET)
    public Franchise getFranchise(@PathVariable int id){
        return franchiseDao.getFranchise(id);
    }

    @RequestMapping(value = "api/franchises", method = RequestMethod.GET)
    public List<Franchise> getFranchises(){
        return franchiseDao.getFranchises();
    }

    @RequestMapping(value = "api/franchise", method = RequestMethod.POST)
    public void addFranchise(@RequestBody Franchise franchise){
        franchiseDao.addFranchise(franchise);
    }

    @RequestMapping(value = "api/franchise/{id}", method = RequestMethod.DELETE)
    public void removeFranchise(@PathVariable int id){
        franchiseDao.removeFranchise(id);
    }
}
