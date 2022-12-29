package com.myanimu.dao;

import com.myanimu.models.Film;
import com.myanimu.models.Multimedia;
import com.myanimu.models.Serie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
@Transactional
public class MultimediaDAOImpl implements MultimediaDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Serie> getSeries() {
        String query = "FROM Serie";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Film> getFilms() {
        String query = "FROM Film";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeSerie(int id) {
        Serie serie = entityManager.find(Serie.class, id);
        entityManager.remove(serie);
    }

    @Override
    public void removeFilm(int id) {
        Film film = entityManager.find(Film.class, id);
        entityManager.remove(film);
    }

    @Override
    public void addSerie(Serie serie) {
        if (entityManager.find(Film.class, serie.getId()) != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "It is already a film");
        entityManager.merge(serie);
    }

    @Override
    public void addFilm(Film film) {
        if (entityManager.find(Serie.class, film.getId()) != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "It is already a serie");
        entityManager.merge(film);
    }

    @Override
    public Serie getSerie(int id) {
        return entityManager.find(Serie.class, id);
    }

    @Override
    public Film getFilm(int id) {
        return entityManager.find(Film.class, id);
    }

    @Override
    public List<Serie> getSerieByName(String name) {
        String query = "FROM Serie WHERE name = :name";
        List<Serie> series = entityManager.createQuery(query).setParameter("name", name).getResultList();
        if (series.isEmpty()){
            return null;
        }
        return series;
    }

    @Override
    public List<Film> getFilmByName(String name) {
        String query = "FROM Film WHERE name = :name";
        List<Film> films = entityManager.createQuery(query).setParameter("name", name).getResultList();
        if (films.isEmpty()){
            return null;
        }
        return films;
    }
}
