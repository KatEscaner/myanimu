package com.myanimu.controllers;

import com.myanimu.dao.StudioDAO;
import com.myanimu.models.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudioController {

    @Autowired
    private StudioDAO studioDao;

    @RequestMapping(value = "user/studio/{id}", method = RequestMethod.GET)
    public Studio getStudio(@PathVariable int id){
        return studioDao.getStudio(id);
    }

    @RequestMapping(value = "user/studios", method = RequestMethod.GET)
    public List<Studio> getStudios(){
        return studioDao.getStudios();
    }

    @RequestMapping(value = "admin/studio", method = RequestMethod.POST)
    public void addStudio(@RequestBody Studio studio){
        studioDao.addStudio(studio);
    }

    @RequestMapping(value = "admin/studio/{id}", method = RequestMethod.DELETE)
    public void removeStudio(@PathVariable int id){
        studioDao.removeStudio(id);
    }
}
