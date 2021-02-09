package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.data.PathException;
import com.epam.task.third.entities.Tetrahedron;
import com.epam.task.third.parsing.DataValidator;
import com.epam.task.third.parsing.FigureCreator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private static final Logger LOGGER = Logger.getLogger(Director.class);

    private DataReader dataReader;
    private DataValidator dataValidator;
    private FigureCreator figureCreator;

    private static final int ID_MAXIMUM = 9999;
    private static final int ID_MINIMUM = 1000;

    public Director(DataReader dataReader, DataValidator dataValidator, FigureCreator figureCreator) {
        this.dataReader = dataReader;
        this.dataValidator = dataValidator;
        this.figureCreator = figureCreator;
    }

    public List<Tetrahedron> createFiguresFromFileData(String filename) {
        List<Tetrahedron> createdFigures = new ArrayList<>();

        try {
            List<String> lines = new ArrayList<>(dataReader.readDataFromFile(filename));
            for (String line : lines){
                if (dataValidator.validateLineContent(line)) {
                    Tetrahedron tetrahedron = figureCreator.createFigure(line);
                    setTetrahedronId(tetrahedron);
                    createdFigures.add(tetrahedron);
                }
            }
        } catch (DataException | PathException  e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
        LOGGER.info("The Tetrahedron figures was successfully created from file data");
        return createdFigures;
    }

    public void setTetrahedronId (Tetrahedron tetrahedron){
        tetrahedron.setId((int) ((Math.random()*(ID_MAXIMUM - ID_MINIMUM)) + ID_MINIMUM));
    }
}
