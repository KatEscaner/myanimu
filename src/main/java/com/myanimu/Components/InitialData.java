package com.myanimu.Components;

import com.myanimu.dao.*;
import com.myanimu.models.*;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class InitialData implements ApplicationRunner {

    @Autowired
    UserDAO userDAO;

    @Autowired
    StudioDAO studioDAO;

    @Autowired
    FranchiseDAO franchiseDAO;

    @Autowired
    GenreDAO genreDAO;

    @Autowired
    MultimediaDAO multimediaDAO;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<User> users = new ArrayList<>();
        List<Studio> studios = new ArrayList<>();
        List<Franchise> franchises = new ArrayList<>();
        List<Genre> genres = new ArrayList<>();
        List<Serie> series = new ArrayList<>();
        List<Film> films = new ArrayList<>();

        //GET INITIAL DATA FROM JSON FILE
        try{
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader("src/main/java/com/myanimu/Components/Data.json"));

            JSONArray userArray = (JSONArray) jsonObject.get("User");
            for (Object o : userArray) {
                User user = new User();
                JSONObject jsonObjectUser = (JSONObject) o;
                user.setUsername(jsonObjectUser.getAsString("username"));
                user.setPassword(jsonObjectUser.getAsString("password"));
                user.setEmail(jsonObjectUser.getAsString("email"));
                user.setAge((int) jsonObjectUser.getAsNumber("age"));
                user.setCountry(jsonObjectUser.getAsString("country"));
                users.add(user);
            }

            JSONArray studioArray = (JSONArray) jsonObject.get("Studio");
            for (Object o : studioArray){
                Studio studio = new Studio();
                JSONObject jsonObjectStudio = (JSONObject) o;
                studio.setName(jsonObjectStudio.getAsString("name"));
                studios.add(studio);
            }

            JSONArray franchiseArray = (JSONArray) jsonObject.get("Franchise");
            for (Object o : franchiseArray){
                Franchise franchise = new Franchise();
                JSONObject jsonObjectFranchise = (JSONObject) o;
                franchise.setName(jsonObjectFranchise.getAsString("name"));
                franchise.setDescription(jsonObjectFranchise.getAsString("description"));
                franchises.add(franchise);
            }

            JSONArray genreArray = (JSONArray) jsonObject.get("Genre");
            for (Object o : genreArray){
                Genre genre = new Genre();
                JSONObject jsonObjectGenre = (JSONObject) o;
                genre.setName(jsonObjectGenre.getAsString("name"));
                genres.add(genre);
            }

            JSONArray serieArray = (JSONArray) jsonObject.get("Serie");
            for (Object o : serieArray){
                Serie serie = new Serie();
                JSONObject jsonObjectSerie = (JSONObject) o;
                serie.setName(jsonObjectSerie.getAsString("name"));
                serie.setDescription(jsonObjectSerie.getAsString("description"));
                serie.setYear((int) jsonObjectSerie.getAsNumber("year"));
                serie.setFinished(Objects.equals(jsonObjectSerie.getAsString("finished"), "true"));
                serie.setAverageDuration((int) jsonObjectSerie.getAsNumber("averageDuration"));
                serie.setNumCaps((int) jsonObjectSerie.getAsNumber("numCaps"));
                Franchise franchise = new Franchise();
                franchise.setName(jsonObjectSerie.getAsString("franchise"));
                serie.setFranchise(franchise);
                Studio studio = new Studio();
                studio.setName(jsonObjectSerie.getAsString("studio"));
                serie.setStudio(studio);
                series.add(serie);
            }

            JSONArray filmArray = (JSONArray) jsonObject.get("Film");
            for (Object o : filmArray){
                Film film = new Film();
                JSONObject jsonObjectFilm = (JSONObject) o;
                film.setName(jsonObjectFilm.getAsString("name"));
                film.setDescription(jsonObjectFilm.getAsString("description"));
                film.setYear((int) jsonObjectFilm.getAsNumber("year"));
                film.setDuration((int) jsonObjectFilm.getAsNumber("duration"));
                Franchise franchise = new Franchise();
                franchise.setName(jsonObjectFilm.getAsString("franchise"));
                film.setFranchise(franchise);
                Studio studio = new Studio();
                studio.setName(jsonObjectFilm.getAsString("studio"));
                film.setStudio(studio);
                films.add(film);
            }



        } catch (IOException e){
            e.printStackTrace();
        }

        //ADD INITIAL DATA TO THE DATEBASE
        users.stream().forEach(user -> {
            if (userDAO.getUser(user.getUsername()) == null)
                userDAO.addUser(user);
        });

        studios.stream().forEach(studio -> {
            if (studioDAO.getStudioByName(studio.getName()) == null)
                studioDAO.addStudio(studio);
        });

        franchises.stream().forEach(franchise -> {
            if (franchiseDAO.getFranchiseByName(franchise.getName()) == null)
                franchiseDAO.addFranchise(franchise);
        });

        genres.stream().forEach(genre -> {
            if (genreDAO.getGenreByName(genre.getName()) == null)
                genreDAO.addGenre(genre);
        });

        series.stream().forEach(serie -> {
            if (multimediaDAO.getSerieByName(serie.getName()) == null){
                serie.setFranchise(franchiseDAO.getFranchiseByName(serie.getFranchise().getName()).get(0));
                serie.setStudio(studioDAO.getStudioByName(serie.getStudio().getName()).get(0));
                multimediaDAO.addSerie(serie);
            }
        });

        films.stream().forEach(film -> {
            if (multimediaDAO.getFilmByName(film.getName()) == null){
                film.setFranchise(franchiseDAO.getFranchiseByName(film.getFranchise().getName()).get(0));
                film.setStudio(studioDAO.getStudioByName(film.getStudio().getName()).get(0));
                multimediaDAO.addFilm(film);
            }
        });




        //        //-----------------Conditions-----------------
//
//        if (multimediaDAO.getSerieByName(serieFateStayNight.getName()) == null){
//            if (franchiseDAO.getFranchiseByName(franchiseFate.getName()) != null)
//                serieFateStayNight.setFranchise(franchiseDAO.getFranchiseByName(franchiseFate.getName()).get(0));
//            if (studioDAO.getStudioByName(studioUfotable.getName()) != null)
//                serieFateStayNight.setStudio(studioDAO.getStudioByName(studioUfotable.getName()).get(0));
//            multimediaDAO.addSerie(serieFateStayNight);
//        }
//
//        if (multimediaDAO.getFilmByName(filmFateStayNightHeavenSFeel.getName()) == null){
//            if (franchiseDAO.getFranchiseByName(franchiseFate.getName()) != null)
//                filmFateStayNightHeavenSFeel.setFranchise(franchiseDAO.getFranchiseByName(franchiseFate.getName()).get(0));
//            if (studioDAO.getStudioByName(studioUfotable.getName()) != null)
//                filmFateStayNightHeavenSFeel.setStudio(studioDAO.getStudioByName(studioUfotable.getName()).get(0));
//            multimediaDAO.addFilm(filmFateStayNightHeavenSFeel);
//        }
    }
}
