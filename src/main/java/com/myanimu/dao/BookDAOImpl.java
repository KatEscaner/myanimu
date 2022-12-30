package com.myanimu.dao;

import com.myanimu.models.Manga;
import com.myanimu.models.Novel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Manga> getMangas() {
        String query = "FROM Manga";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Novel> getNovels() {
        String query = "FROM Novel";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeManga(int isbn) {
        Manga manga = entityManager.find(Manga.class, isbn);
        entityManager.remove(manga);
    }

    @Override
    public void removeNovel(int isbn) {
        Novel novel = entityManager.find(Novel.class, isbn);
        entityManager.remove(novel);
    }

    @Override
    public void addManga(Manga manga) {
        entityManager.merge(manga);
    }

    @Override
    public void addNovel(Novel novel) {
        entityManager.merge(novel);
    }

    @Override
    public Manga getManga(int isbn) {
        return entityManager.find(Manga.class, isbn);
    }

    @Override
    public Novel getNovel(int isbn) {
        return entityManager.find(Novel.class, isbn);
    }

    @Override
    public List<Manga> getMangaByName(String name) {
        String query = "FROM Manga WHERE name = :name";
        List<Manga> mangas = entityManager.createQuery(query).setParameter("name", name).getResultList();
        if (mangas.isEmpty()){
            return null;
        }
        return mangas;
    }

    @Override
    public List<Novel> getNovelByName(String name) {
        String query = "FROM Novel WHERE name = :name";
        List<Novel> novels = entityManager.createQuery(query).setParameter("name", name).getResultList();
        if (novels.isEmpty()){
            return null;
        }
        return novels;
    }
}
