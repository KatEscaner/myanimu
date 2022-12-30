package com.myanimu.dao;

import com.myanimu.jsonRequest.ListFilm;
import com.myanimu.jsonRequest.ListManga;
import com.myanimu.jsonRequest.ListNovel;
import com.myanimu.jsonRequest.ListSerie;
import com.myanimu.models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class ListAnimeImpl implements ListAnimeDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ListAnime> getListAnimes() {
        String query = "FROM ListAnime";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ListAnime getListAnime(int id) {
        return entityManager.find(ListAnime.class, id);
    }

    @Override
    public ListAnime getListByUser(String username) {
        String query = "FROM ListAnime WHERE user = :user";
        User user = entityManager.find(User.class, username);
        List<ListAnime> listAnimes = entityManager.createQuery(query).setParameter("user", user).getResultList();
        return listAnimes.get(0);
    }

    @Override
    public void addListAnime(ListAnime listAnime) {
        entityManager.merge(listAnime);
    }

    @Override
    public void addListSerie(ListSerie listSerie) {
        ListAnime listAnime = entityManager.find(ListAnime.class, listSerie.getList());
        Serie serie = entityManager.find(Serie.class, listSerie.getSerie());
        Set<Serie> series = listAnime.getSeries();
        series.add(serie);
        Set<ListAnime> listAnimes = serie.getListAnimes();
        listAnimes.add(listAnime);
        serie.setListAnimes(listAnimes);
        listAnime.setSeries(series);
        entityManager.merge(serie);
        entityManager.merge(listAnime);
    }

    @Override
    public void addListFilm(ListFilm listFilm) {
        System.out.println(listFilm);
        ListAnime listAnime = entityManager.find(ListAnime.class, listFilm.getFilm());
        Film film = entityManager.find(Film.class, listFilm.getFilm());
        System.out.println(film);
        Set<Film> films = listAnime.getFilms();
        films.add(film);
        Set<ListAnime> listAnimes = film.getListAnimes();
        listAnimes.add(listAnime);
        film.setListAnimes(listAnimes);
        listAnime.setFilms(films);
        entityManager.merge(film);
        entityManager.merge(listAnime);
    }

    @Override
    public void removeListSerie(ListSerie listSerie) {
        ListAnime listAnime = entityManager.find(ListAnime.class, listSerie.getList());
        Serie serie = entityManager.find(Serie.class, listSerie.getSerie());
        Set<Serie> series = listAnime.getSeries();
        series.remove(serie);
        Set<ListAnime> listAnimes = serie.getListAnimes();
        listAnimes.remove(listAnime);
        serie.setListAnimes(listAnimes);
        listAnime.setSeries(series);
        entityManager.merge(serie);
        entityManager.merge(listAnime);
    }

    @Override
    public void removeListFilm(ListFilm listFilm) {
        ListAnime listAnime = entityManager.find(ListAnime.class, listFilm.getFilm());
        Film film = entityManager.find(Film.class, listFilm.getFilm());
        Set<Film> films = listAnime.getFilms();
        films.remove(film);
        Set<ListAnime> listAnimes = film.getListAnimes();
        listAnimes.remove(listAnime);
        film.setListAnimes(listAnimes);
        listAnime.setFilms(films);
        entityManager.merge(film);
        entityManager.merge(listAnime);
    }

    @Override
    public void addListManga(ListManga listManga) {
        ListAnime listAnime = entityManager.find(ListAnime.class, listManga.getList());
        Manga manga = entityManager.find(Manga.class, listManga.getManga());
        Set<Manga> mangas = listAnime.getMangas();
        mangas.add(manga);
        Set<ListAnime> listAnimes = manga.getListAnimes();
        listAnimes.add(listAnime);
        manga.setListAnimes(listAnimes);
        listAnime.setMangas(mangas);
        entityManager.merge(manga);
        entityManager.merge(listAnime);
    }

    @Override
    public void addListNovel(ListNovel listNovel) {
        ListAnime listAnime = entityManager.find(ListAnime.class, listNovel.getList());
        Novel novel = entityManager.find(Novel.class, listNovel.getNovel());
        Set<Novel> novels = listAnime.getNovels();
        novels.add(novel);
        Set<ListAnime> listAnimes = novel.getListAnimes();
        listAnimes.add(listAnime);
        novel.setListAnimes(listAnimes);
        listAnime.setNovels(novels);
        entityManager.merge(novel);
        entityManager.merge(listAnime);
    }

    @Override
    public void removeListManga(ListManga listManga) {
        ListAnime listAnime = entityManager.find(ListAnime.class, listManga.getList());
        Manga manga = entityManager.find(Manga.class, listManga.getManga());
        Set<Manga> mangas = listAnime.getMangas();
        mangas.remove(manga);
        Set<ListAnime> listAnimes = manga.getListAnimes();
        listAnimes.remove(listAnime);
        manga.setListAnimes(listAnimes);
        listAnime.setMangas(mangas);
        entityManager.merge(manga);
        entityManager.merge(listAnime);
    }

    @Override
    public void removeListNovel(ListNovel listNovel) {
        ListAnime listAnime = entityManager.find(ListAnime.class, listNovel.getList());
        Novel novel = entityManager.find(Novel.class, listNovel.getNovel());
        Set<Novel> novels = listAnime.getNovels();
        novels.remove(novel);
        Set<ListAnime> listAnimes = novel.getListAnimes();
        listAnimes.remove(listAnime);
        novel.setListAnimes(listAnimes);
        listAnime.setNovels(novels);
        entityManager.merge(novel);
        entityManager.merge(listAnime);
    }
}
