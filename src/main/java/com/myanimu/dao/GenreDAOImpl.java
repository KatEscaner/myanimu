package com.myanimu.dao;

import com.myanimu.models.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class GenreDAOImpl implements GenreDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Genre> getGenres() {
        String query = "FROM Genre";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeGenre(int id) {
        Genre genre = entityManager.find(Genre.class, id);
        entityManager.remove(genre);
    }

    @Override
    public void addGenre(Genre genre) {
        entityManager.merge(genre);
    }

    @Override
    public Genre getGenre(int id) {
        return entityManager.find(Genre.class, id);
    }

    @Override
    public List<Genre> getGenreByName(String name) {
        String query = "FROM Genre WHERE name = :name";
        List<Genre> genres = entityManager.createQuery(query).setParameter("name", name).getResultList();
        if(genres.isEmpty()){
            return null;
        }
        return genres;
    }
}
