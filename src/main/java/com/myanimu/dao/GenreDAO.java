package com.myanimu.dao;

import com.myanimu.jsonRequest.GenreFilm;
import com.myanimu.jsonRequest.GenreManga;
import com.myanimu.jsonRequest.GenreNovel;
import com.myanimu.jsonRequest.GenreSerie;
import com.myanimu.models.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> getGenres();
    void removeGenre(int id);
    void addGenre(Genre genre);
    Genre getGenre(int id);
    List<Genre> getGenreByName(String name);
    void addGenreSerie(GenreSerie genreSerie);
    void addGenreFilm(GenreFilm genreFilm);
    void removeGenreSerie(GenreSerie genreSerie);
    void removeGenreFilm(GenreFilm genreFilm);
    void addGenreManga(GenreManga genreManga);
    void addGenreNovel(GenreNovel genreNovel);
    void removeGenreManga(GenreManga genreManga);
    void removeGenreNovel(GenreNovel genreNovel);

}
