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

    @RequestMapping(value = "user/mangas", method = RequestMethod.GET)
    public List<Manga> getMangas(){
        return bookDAO.getMangas();
    }

    @RequestMapping(value = "user/novelas", method = RequestMethod.GET)
    public List<Novel> getNovels(){
        return bookDAO.getNovels();
    }

    @RequestMapping(value = "user/manga/{isbn}", method = RequestMethod.GET)
    public Manga getManga(@PathVariable int isbn){
        return bookDAO.getManga(isbn);
    }

    @RequestMapping(value = "user/novel/{isbn}", method = RequestMethod.GET)
    public Novel getNovel(@PathVariable int isbn){
        return bookDAO.getNovel(isbn);
    }

    @RequestMapping(value = "admin/manga", method = RequestMethod.POST)
    public void addManga(@RequestBody Manga manga){
        bookDAO.addManga(manga);
    }

    @RequestMapping(value = "admin/novel", method = RequestMethod.POST)
    public void addNovel(@RequestBody Novel novel){
        bookDAO.addNovel(novel);
    }

    @RequestMapping(value = "admin/manga/{isbn}", method = RequestMethod.DELETE)
    public void removeManga(@PathVariable int isbn){
        bookDAO.removeManga(isbn);
    }

    @RequestMapping(value = "admin/novel/{isbn}", method = RequestMethod.DELETE)
    public void removeNovel(@PathVariable int isbn){
        bookDAO.removeNovel(isbn);
    }
}
