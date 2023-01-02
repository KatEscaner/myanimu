package com.myanimu.controllers;

import com.myanimu.dao.GenreDAO;
import com.myanimu.jsonRequest.GenreFilm;
import com.myanimu.jsonRequest.GenreManga;
import com.myanimu.jsonRequest.GenreNovel;
import com.myanimu.jsonRequest.GenreSerie;
import com.myanimu.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @RequestMapping(value = "api/genreserie/{id}", method = RequestMethod.GET)
    public Set<Serie> getGenreSerie(@PathVariable int id){
        return genreDAO.getGenre(id).getSeries();
    }

    @RequestMapping(value = "api/genrefilm/{id}", method = RequestMethod.GET)
    public Set<Film> getGenreFilm(@PathVariable int id){
        return genreDAO.getGenre(id).getFilms();
    }

    @RequestMapping(value = "api/genreserie", method = RequestMethod.POST)
    public void addGenreSerie(@RequestBody GenreSerie genreSerie){
        genreDAO.addGenreSerie(genreSerie);
    }

    @RequestMapping(value = "api/genrefilm", method = RequestMethod.POST)
    public void addGenreFilm(@RequestBody GenreFilm genreFilm){
        genreDAO.addGenreFilm(genreFilm);
    }

    @RequestMapping(value = "api/genreserie", method = RequestMethod.DELETE)
    public void removeGenreSerie(@RequestBody GenreSerie genreSerie){
        genreDAO.removeGenreSerie(genreSerie);
    }

    @RequestMapping(value = "api/genrefilm", method = RequestMethod.DELETE)
    public void removeGenreFilm(@RequestBody GenreFilm genreFilm){
        genreDAO.removeGenreFilm(genreFilm);
    }

    @RequestMapping(value = "api/genremanga/{id}", method = RequestMethod.GET)
    public Set<Manga> getGenreManga(@PathVariable int id){
        return genreDAO.getGenre(id).getMangas();
    }

    @RequestMapping(value = "api/genrenovel/{id}", method = RequestMethod.GET)
    public Set<Novel> getGenreNovel(@PathVariable int id){
        return genreDAO.getGenre(id).getNovels();
    }

    @RequestMapping(value = "api/genremanga", method = RequestMethod.POST)
    public void addGenreManga(@RequestBody GenreManga genreManga){
        genreDAO.addGenreManga(genreManga);
    }

    @RequestMapping(value = "api/genrenovel", method = RequestMethod.POST)
    public void addGenreNovel(@RequestBody GenreNovel genreNovel){
        genreDAO.addGenreNovel(genreNovel);
    }

    @RequestMapping(value = "api/genremanga", method = RequestMethod.DELETE)
    public void removeGenreManga(@RequestBody GenreManga genreManga){
        genreDAO.removeGenreManga(genreManga);
    }

    @RequestMapping(value = "api/genrenovel", method = RequestMethod.DELETE)
    public void removeGenreNovel(@RequestBody GenreNovel genreNovel){
        genreDAO.removeGenreNovel(genreNovel);
    }
}
