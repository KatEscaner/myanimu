package com.myanimu.dao;

import com.myanimu.models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FranchiseDAOImpl implements FranchiseDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Franchise> getFranchises() {
        String query = "FROM Franchise";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeFranchise(int id) {
        String querySerie = "FROM Serie WHERE franchise = :franchise";
        String queryFilm = "FROM Film WHERE franchise = :franchise";
        String queryManga = "FROM Manga WHERE franchise = :franchise";
        String queryNovel = "FROM Novel WHERE franchise = :franchise";
        Franchise franchise = entityManager.find(Franchise.class, id);
        List<Serie> series = entityManager.createQuery(querySerie).setParameter("franchise", franchise).getResultList();
        List<Film> films = entityManager.createQuery(queryFilm).setParameter("franchise", franchise).getResultList();
        List<Manga> mangas = entityManager.createQuery(queryManga).setParameter("franchise", franchise).getResultList();
        List<Novel> novels = entityManager.createQuery(queryNovel).setParameter("franchise", franchise).getResultList();

        series.stream().forEach(serie -> {
            serie.setFranchise(null);
            entityManager.merge(serie);
        });

        films.stream().forEach(film -> {
            film.setFranchise(null);
            entityManager.merge(film);
        });

        mangas.stream().forEach(manga -> {
            manga.setFranchise(null);
            entityManager.merge(manga);
        });

        novels.stream().forEach(novel -> {
            System.out.println(novel.getIsbn());
            novel.setFranchise(null);
            entityManager.merge(novel);
        });

        franchise.setMultimedias(null);
        franchise.setBooks(null);
        entityManager.merge(franchise);
        entityManager.remove(franchise);
    }

    @Override
    public void addFranchise(Franchise franchise) {
        entityManager.merge(franchise);
    }

    @Override
    public Franchise getFranchise(int id) {
        return entityManager.find(Franchise.class, id);
    }

    @Override
    public List<Franchise> getFranchiseByName(String name) {
        String query = "FROM Franchise WHERE name = :name";
        List<Franchise> franchises = entityManager.createQuery(query).setParameter("name", name).getResultList();
        if(franchises.isEmpty()){
            return null;
        }
        return franchises;
    }
}
