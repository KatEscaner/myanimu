package com.myanimu.dao;

import com.myanimu.models.Film;
import com.myanimu.models.Serie;

import java.util.List;

public interface MultimediaDAO {

    List<Serie> getSeries();
    List<Film> getFilms();
    void removeSerie(int id);
    void removeFilm(int id);
    void addSerie(Serie serie);
    void addFilm(Film film);
    Serie getSerie(int id);
    Film getFilm(int id);
    List<Serie> getSerieByName(String name);
    List<Film> getFilmByName(String name);
}
