package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {

    private Map<Integer, Tetrahedron> store = new HashMap<>();

    private TetrahedronRepositoryImpl() {
    }

    private static class SingletonHolder {
        private static final TetrahedronRepositoryImpl REPOSITORY = new TetrahedronRepositoryImpl();
    }

    public static TetrahedronRepositoryImpl getRepository() {
        return SingletonHolder.REPOSITORY;
    }

    public void addTetrahedron(Tetrahedron tetrahedron) {
        int tetrahedronId = tetrahedron.getId();
        store.put(tetrahedronId, tetrahedron);
    }

    public void removeTetrahedron(Tetrahedron tetrahedron) {
        int tetrahedronId = tetrahedron.getId();
        store.remove(tetrahedronId);
    }

    public void updateTetrahedron(Tetrahedron tetrahedron) {
        int tetrahedronId = tetrahedron.getId();
        store.put(tetrahedronId, tetrahedron);
    }

    public List<Tetrahedron> query(TetrahedronSpecification specification) {
        List<Tetrahedron> queryResults = new ArrayList<>();
        for (Tetrahedron tetrahedron : store.values()) {
            if (specification.isConformsTo(tetrahedron)) {
                queryResults.add(tetrahedron);
            }
        }
        return queryResults;
    }
}
