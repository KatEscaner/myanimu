package com.myanimu.controllers;

import com.myanimu.dao.MultimediaDAO;
import com.myanimu.models.Film;
import com.myanimu.models.Multimedia;
import com.myanimu.models.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MultimediaController {

    @Autowired
    private MultimediaDAO multimediaDAO;

    @RequestMapping(value = "api/series", method = RequestMethod.GET)
    public List<Serie> getSeries(){
        return multimediaDAO.getSeries();
    }

    @RequestMapping(value = "api/films", method = RequestMethod.GET)
    public List<Film> getFilms(){
        return multimediaDAO.getFilms();
    }

    @RequestMapping(value = "api/serie/{id}", method = RequestMethod.GET)
    public Serie getSerie(@PathVariable int id){
        return multimediaDAO.getSerie(id);
    }

    @RequestMapping(value = "api/film/{id}", method = RequestMethod.GET)
    public Film getFilm(@PathVariable int id){
        return multimediaDAO.getFilm(id);
    }

    @RequestMapping(value = "api/serie", method = RequestMethod.POST)
    public void addSerie(@RequestBody Serie serie){
        multimediaDAO.addSerie(serie);
    }

    @RequestMapping(value = "api/film", method = RequestMethod.POST)
    public void addFilm(@RequestBody Film film){
        multimediaDAO.addFilm(film);
    }

    @RequestMapping(value = "api/serie/{id}", method = RequestMethod.DELETE)
    public void removeSerie(@PathVariable int id){
        multimediaDAO.removeSerie(id);
    }
    
    @RequestMapping(value = "api/film/{id}", method = RequestMethod.DELETE)
    public void removeFilm(@PathVariable int id){
        multimediaDAO.removeFilm(id);
    }
}
