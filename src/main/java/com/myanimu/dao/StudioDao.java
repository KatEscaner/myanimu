package com.myanimu.dao;

import com.myanimu.models.Studio;

import java.util.List;

public interface StudioDao {
    List<Studio> getStudios();
    void remove(int id);
    void add(Studio studio);
    Studio getStudio(int id);
}
