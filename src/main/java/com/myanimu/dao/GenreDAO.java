package com.myanimu.dao;

import com.myanimu.models.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> getGenres();
    void removeGenre(int id);
    void addGenre(Genre genre);
    Genre getGenre(int id);
    List<Genre> getGenreByName(String name);
}
