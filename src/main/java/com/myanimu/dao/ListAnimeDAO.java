package com.myanimu.dao;

import com.myanimu.jsonRequest.ListFilm;
import com.myanimu.jsonRequest.ListSerie;
import com.myanimu.models.ListAnime;

import java.util.List;

public interface ListAnimeDAO {

    List<ListAnime> getListAnimes();
    ListAnime getListAnime(int id);
    ListAnime getListByUser(String username);
    void addListAnime(ListAnime listAnime);
    void addListSerie(ListSerie listSerie);
    void addListFilm(ListFilm listFilm);
    void removeListSerie(ListSerie listSerie);
    void removeListFilm(ListFilm listFilm);
}
