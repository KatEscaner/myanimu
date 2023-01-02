package com.myanimu.dao;

import com.myanimu.jsonRequest.GenreFilm;
import com.myanimu.jsonRequest.GenreManga;
import com.myanimu.jsonRequest.GenreNovel;
import com.myanimu.jsonRequest.GenreSerie;
import com.myanimu.models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.util.List;
import java.util.Set;

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

    @Override
    public void addGenreSerie(GenreSerie genreSerie) {
        Genre genre = entityManager.find(Genre.class, genreSerie.getGenre());
        Serie serie = entityManager.find(Serie.class, genreSerie.getSerie());
        Set<Serie> series = genre.getSeries();
        series.add(serie);
        Set<Genre> genres = serie.getGenres();
        genres.add(genre);
        serie.setGenres(genres);
        genre.setSeries(series);
        entityManager.merge(serie);
        entityManager.merge(genre);
    }

    @Override
    public void addGenreFilm(GenreFilm genreFilm) {
        Genre genre = entityManager.find(Genre.class, genreFilm.getGenre());
        Film film = entityManager.find(Film.class, genreFilm.getFilm());
        Set<Film> films = genre.getFilms();
        films.add(film);
        Set<Genre> genres = film.getGenres();
        genres.add(genre);
        film.setGenres(genres);
        genre.setFilms(films);
        entityManager.merge(film);
        entityManager.merge(genre);
    }

    @Override
    public void removeGenreSerie(GenreSerie genreSerie) {
        Genre genre = entityManager.find(Genre.class, genreSerie.getGenre());
        Serie serie = entityManager.find(Serie.class, genreSerie.getSerie());
        Set<Serie> series = genre.getSeries();
        series.remove(serie);
        Set<Genre> genres = serie.getGenres();
        genres.remove(genre);
        serie.setGenres(genres);
        genre.setSeries(series);
        entityManager.merge(serie);
        entityManager.merge(genre);
    }

    @Override
    public void removeGenreFilm(GenreFilm genreFilm) {
        Genre genre = entityManager.find(Genre.class, genreFilm.getGenre());
        Film film = entityManager.find(Film.class, genreFilm.getFilm());
        Set<Film> films = genre.getFilms();
        films.remove(film);
        Set<Genre> genres = film.getGenres();
        genres.remove(genre);
        film.setGenres(genres);
        genre.setFilms(films);
        entityManager.merge(film);
        entityManager.merge(genre);
    }

    @Override
    public void addGenreManga(GenreManga genreManga) {
        Genre genre = entityManager.find(Genre.class, genreManga.getGenre());
        Manga manga = entityManager.find(Manga.class, genreManga.getManga());
        Set<Manga> mangas = genre.getMangas();
        mangas.add(manga);
        Set<Genre> genres = manga.getGenres();
        genres.add(genre);
        manga.setGenres(genres);
        genre.setMangas(mangas);
        entityManager.merge(manga);
        entityManager.merge(genre);
    }

    @Override
    public void addGenreNovel(GenreNovel genreNovel) {
        Genre genre = entityManager.find(Genre.class, genreNovel.getGenre());
        Novel novel = entityManager.find(Novel.class, genreNovel.getNovel());
        Set<Novel> novels = genre.getNovels();
        novels.add(novel);
        Set<Genre> genres = novel.getGenres();
        genres.add(genre);
        genre.setNovels(novels);
        novel.setGenres(genres);
        entityManager.merge(novel);
        entityManager.merge(genre);
    }

    @Override
    public void removeGenreManga(GenreManga genreManga) {
        Genre genre = entityManager.find(Genre.class, genreManga.getGenre());
        Manga manga = entityManager.find(Manga.class, genreManga.getManga());
        Set<Manga> mangas = genre.getMangas();
        mangas.remove(manga);
        Set<Genre> genres = manga.getGenres();
        genres.remove(genre);
        manga.setGenres(genres);
        genre.setMangas(mangas);
        entityManager.merge(manga);
        entityManager.merge(genre);
    }

    @Override
    public void removeGenreNovel(GenreNovel genreNovel) {
        Genre genre = entityManager.find(Genre.class, genreNovel.getGenre());
        Novel novel = entityManager.find(Novel.class, genreNovel.getNovel());
        Set<Novel> novels = genre.getNovels();
        novels.remove(novel);
        Set<Genre> genres = novel.getGenres();
        genres.remove(genre);
        genre.setNovels(novels);
        novel.setGenres(genres);
        entityManager.merge(novel);
        entityManager.merge(genre);
    }
}
