package com.myanimu.dao;

import com.myanimu.models.Manga;
import com.myanimu.models.Novel;

import java.util.List;

public interface BookDAO {
    List<Manga> getMangas();
    List<Novel> getNovels();
    void removeManga(int isbn);
    void removeNovel(int isbn);
    void addManga(Manga manga);
    void addNovel(Novel novel);
    Manga getManga(int isbn);
    Novel getNovel(int isbn);
    List<Manga> getMangaByName(String name);
    List<Novel> getNovelByName(String string);
}
