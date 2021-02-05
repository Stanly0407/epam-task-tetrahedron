package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.data.PathException;
import com.epam.task.third.entities.Tetrahedron;
import com.epam.task.third.parsing.DataValidator;
import com.epam.task.third.parsing.FigureCreator;
import com.epam.task.third.parsing.NumberInLineException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private static final Logger LOGGER = Logger.getLogger(Director.class);

    private DataReader dataReader;
    private DataValidator dataValidator;
    private FigureCreator figureCreator;

    public Director(DataReader dataReader, DataValidator dataValidator, FigureCreator figureCreator) {
        this.dataReader = dataReader;
        this.dataValidator = dataValidator;
        this.figureCreator = figureCreator;
    }

    public List<Tetrahedron> createFiguresFromFileData(String filename) {
        List<Tetrahedron> createdFigures = new ArrayList<>();
        try {
            List<String> lines = new ArrayList<>(dataReader.readDataFromFile(filename));
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (dataValidator.validateLineContent(line)) {
                    Tetrahedron tetrahedron = figureCreator.createFigure(line);
                    tetrahedron.setId(i);
                    createdFigures.add(tetrahedron);
                }
            }
        } catch (DataException | PathException | NumberInLineException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return createdFigures;
    }
}
