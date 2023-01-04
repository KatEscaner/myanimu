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

    @RequestMapping(value = "user/genres", method = RequestMethod.GET)
    public List<Genre> getGenres(){
        return genreDAO.getGenres();
    }

    @RequestMapping(value = "user/genre/{id}", method = RequestMethod.GET)
    public Genre getGenre(@PathVariable int id){
        return genreDAO.getGenre(id);
    }

    @RequestMapping(value = "admin/genre", method = RequestMethod.POST)
    public void addGenre(@RequestBody Genre genre){
        genreDAO.addGenre(genre);
    }

    @RequestMapping(value = "admin/genre/{id}", method = RequestMethod.DELETE)
    public void removeGenre(@PathVariable int id){
        genreDAO.removeGenre(id);
    }

    @RequestMapping(value = "user/genreserie/{id}", method = RequestMethod.GET)
    public Set<Serie> getGenreSerie(@PathVariable int id){
        return genreDAO.getGenre(id).getSeries();
    }

    @RequestMapping(value = "user/genrefilm/{id}", method = RequestMethod.GET)
    public Set<Film> getGenreFilm(@PathVariable int id){
        return genreDAO.getGenre(id).getFilms();
    }

    @RequestMapping(value = "admin/genreserie", method = RequestMethod.POST)
    public void addGenreSerie(@RequestBody GenreSerie genreSerie){
        genreDAO.addGenreSerie(genreSerie);
    }

    @RequestMapping(value = "admin/genrefilm", method = RequestMethod.POST)
    public void addGenreFilm(@RequestBody GenreFilm genreFilm){
        genreDAO.addGenreFilm(genreFilm);
    }

    @RequestMapping(value = "admin/genreserie", method = RequestMethod.DELETE)
    public void removeGenreSerie(@RequestBody GenreSerie genreSerie){
        genreDAO.removeGenreSerie(genreSerie);
    }

    @RequestMapping(value = "admin/genrefilm", method = RequestMethod.DELETE)
    public void removeGenreFilm(@RequestBody GenreFilm genreFilm){
        genreDAO.removeGenreFilm(genreFilm);
    }

    @RequestMapping(value = "user/genremanga/{id}", method = RequestMethod.GET)
    public Set<Manga> getGenreManga(@PathVariable int id){
        return genreDAO.getGenre(id).getMangas();
    }

    @RequestMapping(value = "user/genrenovel/{id}", method = RequestMethod.GET)
    public Set<Novel> getGenreNovel(@PathVariable int id){
        return genreDAO.getGenre(id).getNovels();
    }

    @RequestMapping(value = "admin/genremanga", method = RequestMethod.POST)
    public void addGenreManga(@RequestBody GenreManga genreManga){
        genreDAO.addGenreManga(genreManga);
    }

    @RequestMapping(value = "admin/genrenovel", method = RequestMethod.POST)
    public void addGenreNovel(@RequestBody GenreNovel genreNovel){
        genreDAO.addGenreNovel(genreNovel);
    }

    @RequestMapping(value = "admin/genremanga", method = RequestMethod.DELETE)
    public void removeGenreManga(@RequestBody GenreManga genreManga){
        genreDAO.removeGenreManga(genreManga);
    }

    @RequestMapping(value = "admin/genrenovel", method = RequestMethod.DELETE)
    public void removeGenreNovel(@RequestBody GenreNovel genreNovel){
        genreDAO.removeGenreNovel(genreNovel);
    }
}
