package com.myanimu.dao;

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
        Studio studio = entityManager.find(Studio.class, id);
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
