package com.myanimu.Components;

import com.myanimu.dao.FranchiseDAO;
import com.myanimu.dao.StudioDAO;
import com.myanimu.dao.UserDAO;
import com.myanimu.models.Franchise;
import com.myanimu.models.Studio;
import com.myanimu.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements ApplicationRunner {

    @Autowired
    UserDAO userDAO;

    @Autowired
    StudioDAO studioDAO;

    @Autowired
    FranchiseDAO franchiseDAO;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userDAO.getUser("pepe") == null) {
            User user = new User();
            user.setUsername("pepe");
            user.setPassword("12345");
            user.setEmail("algo@gmail.com");
            user.setAge(23);
            user.setCountry("ESP");
            userDAO.addUser(user);
        }

        if(studioDAO.getStudioByName("Ufotable") == null) {
            Studio studio = new Studio();
            studio.setName("Ufotable");
            studioDAO.addStudio(studio);
        }

        if(franchiseDAO.getFranchiseByName("Fate") == null) {
            Franchise franchise = new Franchise();
            franchise.setName("Fate");
            franchise.setDescription("something");
            franchiseDAO.addFranchise(franchise);
        }
    }
}
