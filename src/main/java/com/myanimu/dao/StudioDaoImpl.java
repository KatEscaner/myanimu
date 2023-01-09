package com.myanimu.dao;

import com.myanimu.models.Film;
import com.myanimu.models.Serie;
import com.myanimu.models.Studio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class StudioDAOImpl implements StudioDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Studio> getStudios() {
        String query = "FROM Studio";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeStudio(int id) {
        String querySerie = "FROM Serie WHERE studio = :studio";
        String queryFilm = "FROM Film WHERE studio = :studio";
        Studio studio = entityManager.find(Studio.class, id);
        List<Serie> series = entityManager.createQuery(querySerie).setParameter("studio", studio).getResultList();
        List<Film> films = entityManager.createQuery(queryFilm).setParameter("studio", studio).getResultList();

        series.stream().forEach(serie -> {
            serie.setStudio(null);
            entityManager.merge(serie);
        });

        films.stream().forEach(film -> {
            film.setStudio(null);
            entityManager.merge(film);
        });

        studio.setMultimedias(null);
        entityManager.merge(studio);
        entityManager.remove(studio);
    }

    @Override
    public void addStudio(Studio studio) {
        entityManager.merge(studio);
    }

    @Override
    public Studio getStudio(int id) {
        return entityManager.find(Studio.class, id);
    }

    @Override
    public List<Studio> getStudioByName(String name) {
        String query = "FROM Studio WHERE name = :name";
        List<Studio> studios = entityManager.createQuery(query).setParameter("name", name).getResultList();
        if(studios.isEmpty()){
            return null;
        }
        return studios;
    }
}
