package com.epam.task.third;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.data.PathException;
import com.epam.task.third.entities.Tetrahedron;
import com.epam.task.third.parsing.DataValidator;
import com.epam.task.third.parsing.FigureCreator;
import com.epam.task.third.parsing.NumberInLineException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Director {
    private DataReader dataReader;
    private DataValidator dataValidator;
    private FigureCreator figureCreator;

    public Director(DataReader dataReader, DataValidator dataValidator, FigureCreator figureCreator) {
        this.dataReader = dataReader;
        this.dataValidator = dataValidator;
        this.figureCreator = figureCreator;
    }

    public List<Tetrahedron> createFiguresFromFileData(String filename) {
        List<Tetrahedron> tetrahedrons = new ArrayList<>();
        try {
            List<String> lines = new ArrayList<>(dataReader.readDataFromFile(filename));
            for (String line : lines) {
                if (dataValidator.validateLineContent(line) && dataValidator.validateIfNotEmpty(line)) {
                    tetrahedrons.add(figureCreator.createFigure(line));
                }
            }
        } catch (DataException | PathException | NumberInLineException | IOException e) {
            e.getMessage();
        }
        return tetrahedrons;
    }
}
