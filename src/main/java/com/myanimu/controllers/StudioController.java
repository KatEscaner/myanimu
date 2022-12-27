package com.myanimu.controllers;

import com.myanimu.dao.StudioDao;
import com.myanimu.models.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudioController {

    @Autowired
    private StudioDao studioDao;

    @RequestMapping(value = "api/studio/{id}", method = RequestMethod.GET)
    public Studio getStudio(@RequestBody int id){
        return studioDao.getStudio(id);
    }

    @RequestMapping(value = "api/studios", method = RequestMethod.GET)
    public List<Studio> getStudios(){
        return studioDao.getStudios();
    }

    @RequestMapping(value = "api/studio", method = RequestMethod.POST)
    public void addStudio(@RequestBody Studio studio){
        studioDao.add(studio);
    }

    @RequestMapping(value = "api/studio/{id}", method = RequestMethod.DELETE)
    public void removeStudio(@PathVariable int id){
        studioDao.remove(id);
    }
}
