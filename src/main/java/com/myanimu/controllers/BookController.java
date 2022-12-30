package com.myanimu.controllers;

import com.myanimu.dao.BookDAO;
import com.myanimu.models.Manga;
import com.myanimu.models.Novel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @RequestMapping(value = "api/mangas", method = RequestMethod.GET)
    public List<Manga> getMangas(){
        return bookDAO.getMangas();
    }

    @RequestMapping(value = "api/novelas", method = RequestMethod.GET)
    public List<Novel> getNovels(){
        return bookDAO.getNovels();
    }

    @RequestMapping(value = "api/manga/{isbn}", method = RequestMethod.GET)
    public Manga getManga(@PathVariable int isbn){
        return bookDAO.getManga(isbn);
    }

    @RequestMapping(value = "api/novel/{isbn}", method = RequestMethod.GET)
    public Novel getNovel(@PathVariable int isbn){
        return bookDAO.getNovel(isbn);
    }

    @RequestMapping(value = "api/manga", method = RequestMethod.POST)
    public void addManga(@RequestBody Manga manga){
        bookDAO.addManga(manga);
    }

    @RequestMapping(value = "api/novel", method = RequestMethod.POST)
    public void addNovel(@RequestBody Novel novel){
        bookDAO.addNovel(novel);
    }

    @RequestMapping(value = "api/manga/{isbn}", method = RequestMethod.DELETE)
    public void removeManga(@PathVariable int isbn){
        bookDAO.removeManga(isbn);
    }

    @RequestMapping(value = "api/novel/{isbn}", method = RequestMethod.DELETE)
    public void removeNovel(@PathVariable int isbn){
        bookDAO.removeNovel(isbn);
    }
}
