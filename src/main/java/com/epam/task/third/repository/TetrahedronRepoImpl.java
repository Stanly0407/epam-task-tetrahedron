package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;

import java.util.List;
import java.util.Map;

public class TetrahedronRepoImpl implements TetrahedronRepo {

    private Repository repository = Repository.getRepository();
    private Map<Long, Tetrahedron> store = repository.getRepoMap();

    @Override
    public void addTetrahedron(Tetrahedron tetrahedron) {
        long tetrahedronId = tetrahedron.getId();
        store.put(tetrahedronId, tetrahedron);
    }

    @Override
    public void removeTetrahedron(Tetrahedron tetrahedron) {
        long tetrahedronId = tetrahedron.getId();
        store.remove(tetrahedronId);
    }

    @Override
    public void updateTetrahedron(Tetrahedron tetrahedron) {
        long tetrahedronId = tetrahedron.getId();
        store.put(tetrahedronId, tetrahedron);
    }

    @Override
    public List query(TetrahedronSpecificationSearchingOne specification) {
        return null;
    }
}
