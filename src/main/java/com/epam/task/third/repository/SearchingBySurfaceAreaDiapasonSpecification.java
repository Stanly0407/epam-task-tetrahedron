package com.epam.task.third.repository;

import com.epam.task.third.entities.Tetrahedron;
import com.epam.task.third.service.TetrahedronService;

public class SearchingBySurfaceAreaDiapasonSpecification implements TetrahedronSpecification {

    private double diapasonStart;
    private double diapasonFinish;

    private TetrahedronService service = new TetrahedronService();

    public SearchingBySurfaceAreaDiapasonSpecification(double diapasonStart, double diapasonFinish) {
        this.diapasonStart = diapasonStart;
        this.diapasonFinish = diapasonFinish;
    }

    @Override
    public boolean isConformsTo(Tetrahedron tetrahedron) {
        double actualSurfaceArea = service.calculateSurfaceArea(tetrahedron);
        return actualSurfaceArea >= diapasonStart &&
                actualSurfaceArea <= diapasonFinish;
    }
}
