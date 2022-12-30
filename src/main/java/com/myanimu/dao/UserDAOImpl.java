package com.myanimu.dao;

import com.myanimu.models.ListAnime;
import com.myanimu.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getUsers() {
        String query = "FROM Studio";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeUser(String username) {
        User user = entityManager.find(User.class, username);
        String query = "FROM ListAnime WHERE user = :user";
        entityManager.remove(entityManager.createQuery(query).setParameter("user", user.getUsername()));
        entityManager.remove(user);
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
        ListAnime listAnime = new ListAnime();
        listAnime.setUser(user);
        entityManager.merge(listAnime);
    }

    @Override
    public User getUser(String username) {
        return entityManager.find(User.class, username);
    }
}
