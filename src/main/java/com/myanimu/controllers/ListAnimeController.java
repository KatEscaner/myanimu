package com.myanimu.controllers;

import com.myanimu.dao.GenreDAO;
import com.myanimu.dao.ListAnimeDAO;
import com.myanimu.jsonRequest.ListFilm;
import com.myanimu.jsonRequest.ListSerie;
import com.myanimu.models.Film;
import com.myanimu.models.ListAnime;
import com.myanimu.models.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ListAnimeController {

    @Autowired
    private ListAnimeDAO listAnimeDAO;

    @RequestMapping(value = "api/listanimes", method = RequestMethod.GET)
    public List<ListAnime> getListAnimes(){
        return listAnimeDAO.getListAnimes();
    }

    @RequestMapping(value = "api/listanime/{username}", method = RequestMethod.GET)
    public ListAnime getListAnime(@PathVariable String username){
        return listAnimeDAO.getListByUser(username);
    }

    @RequestMapping(value = "api/listserie/{username}", method = RequestMethod.GET)
    public Set<Serie> getListSerie(@PathVariable String username){
        return listAnimeDAO.getListByUser(username).getSeries();
    }

    @RequestMapping(value = "api/listfilm/{username}", method = RequestMethod.GET)
    public Set<Film> getListFilm(@PathVariable String username){
        return listAnimeDAO.getListByUser(username).getFilms();
    }

    @RequestMapping(value = "api/listserie", method = RequestMethod.POST)
    public void addListSerie(@RequestBody ListSerie listSerie){
        listAnimeDAO.addListSerie(listSerie);
    }

    @RequestMapping(value = "api/listfilm", method = RequestMethod.POST)
    public void addListFilm(@RequestBody ListFilm listFilm){
        listAnimeDAO.addListFilm(listFilm);
    }

    @RequestMapping(value = "api/listserie", method = RequestMethod.DELETE)
    private void removeListSerie(@RequestBody ListSerie listSerie){
        listAnimeDAO.removeListSerie(listSerie);
    }

    @RequestMapping(value = "api/listfilm", method = RequestMethod.DELETE)
    private void removeListFilm(@PathVariable ListFilm listFilm){
        listAnimeDAO.removeListFilm(listFilm);
    }
}
