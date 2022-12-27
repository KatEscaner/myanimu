package com.myanimu.dao;

import com.myanimu.dao.StudioDao;
import com.myanimu.models.Studio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class StudioDaoImpl implements StudioDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Studio> getStudios() {
        String query = "FROM Studio";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void remove(int id) {
        Studio studio = entityManager.find(Studio.class, id);
        entityManager.remove(studio);
    }

    @Override
    public void add(Studio studio) {
        entityManager.merge(studio);
    }

    @Override
    public Studio getStudio(int id) {
        return entityManager.find(Studio.class, id);
    }
}
