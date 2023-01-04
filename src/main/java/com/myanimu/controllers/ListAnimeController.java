package com.myanimu.controllers;

import com.myanimu.dao.GenreDAO;
import com.myanimu.dao.ListAnimeDAO;
import com.myanimu.jsonRequest.ListFilm;
import com.myanimu.jsonRequest.ListManga;
import com.myanimu.jsonRequest.ListNovel;
import com.myanimu.jsonRequest.ListSerie;
import com.myanimu.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ListAnimeController {

    @Autowired
    private ListAnimeDAO listAnimeDAO;

    @RequestMapping(value = "user/listanimes", method = RequestMethod.GET)
    public List<ListAnime> getListAnimes(){
        return listAnimeDAO.getListAnimes();
    }

    @RequestMapping(value = "user/listanime/{username}", method = RequestMethod.GET)
    public ListAnime getListAnime(@PathVariable String username){
        return listAnimeDAO.getListByUser(username);
    }

    @RequestMapping(value = "user/listserie/{username}", method = RequestMethod.GET)
    public Set<Serie> getListSerie(@PathVariable String username){
        return listAnimeDAO.getListByUser(username).getSeries();
    }

    @RequestMapping(value = "user/listfilm/{username}", method = RequestMethod.GET)
    public Set<Film> getListFilm(@PathVariable String username){
        return listAnimeDAO.getListByUser(username).getFilms();
    }

    @RequestMapping(value = "admin/listserie", method = RequestMethod.POST)
    public void addListSerie(@RequestBody ListSerie listSerie){
        listAnimeDAO.addListSerie(listSerie);
    }

    @RequestMapping(value = "admin/listfilm", method = RequestMethod.POST)
    public void addListFilm(@RequestBody ListFilm listFilm){
        listAnimeDAO.addListFilm(listFilm);
    }

    @RequestMapping(value = "admin/listserie", method = RequestMethod.DELETE)
    public void removeListSerie(@RequestBody ListSerie listSerie){
        listAnimeDAO.removeListSerie(listSerie);
    }

    @RequestMapping(value = "admin/listfilm", method = RequestMethod.DELETE)
    public void removeListFilm(@PathVariable ListFilm listFilm){
        listAnimeDAO.removeListFilm(listFilm);
    }

    @RequestMapping(value = "user/listmanga/{username}", method = RequestMethod.GET)
    public Set<Manga> getListManga(@PathVariable String username){
        return listAnimeDAO.getListByUser(username).getMangas();
    }

    @RequestMapping(value = "user/listnovel/{username}", method = RequestMethod.GET)
    public Set<Novel> setListNovel(@PathVariable String username){
        return listAnimeDAO.getListByUser(username).getNovels();
    }

    @RequestMapping(value = "admin/listmanga", method = RequestMethod.POST)
    public void addListManga(@RequestBody ListManga listManga){
        listAnimeDAO.addListManga(listManga);
    }

    @RequestMapping(value = "admin/listnovel", method = RequestMethod.POST)
    public void addListNovel(@RequestBody ListNovel listNovel){
        listAnimeDAO.addListNovel(listNovel);
    }

    @RequestMapping(value = "admin/listmanga", method = RequestMethod.DELETE)
    public void removeListManga(@RequestBody ListManga listManga){
        listAnimeDAO.removeListManga(listManga);
    }

    @RequestMapping(value = "admin/listnovel", method = RequestMethod.DELETE)
    public void removeListManga(@RequestBody ListNovel listNovel){
        listAnimeDAO.removeListNovel(listNovel);
    }
}
