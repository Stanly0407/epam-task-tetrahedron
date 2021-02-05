package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private static final Repository REPOSITORY = new Repository();

    private Map<Long, Tetrahedron> store =  new HashMap<>();

    private Repository() {
    }

    public static Repository getRepository(){
        return REPOSITORY;
    }

    public Map<Long, Tetrahedron> getRepoMap() {
        return store;
    }

    public void setRepoMap(Map<Long, Tetrahedron> repoMap) {
        this.store = repoMap;
    }
}
