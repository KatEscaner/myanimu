package com.myanimu.dao;

import com.myanimu.models.Studio;

import java.util.List;

public interface StudioDAO {
    List<Studio> getStudios();
    void removeStudio(int id);
    void addStudio(Studio studio);
    Studio getStudio(int id);
    List<Studio> getStudioByName(String name);
}
