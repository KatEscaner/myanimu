package com.myanimu.controllers;

import com.myanimu.dao.GenreDAO;
import com.myanimu.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    private GenreDAO genreDAO;

    @RequestMapping(value = "api/genres", method = RequestMethod.GET)
    public List<Genre> getGenres(){
        return genreDAO.getGenres();
    }

    @RequestMapping(value = "api/genre/{id}", method = RequestMethod.GET)
    public Genre getGenre(@PathVariable int id){
        return genreDAO.getGenre(id);
    }

    @RequestMapping(value = "api/genre", method = RequestMethod.POST)
    public void addGenre(@RequestBody Genre genre){
        genreDAO.addGenre(genre);
    }

    @RequestMapping(value = "api/genre/{id}", method = RequestMethod.DELETE)
    public void removeGenre(@PathVariable int id){
        genreDAO.removeGenre(id);
    }
}
