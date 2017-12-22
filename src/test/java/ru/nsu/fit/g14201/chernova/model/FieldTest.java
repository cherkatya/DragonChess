package ru.nsu.fit.g14201.chernova.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Катя on 22.12.2017.
 */
public class FieldTest {
    @Test
    public void upFigureCountTest(){
        Field field = new Field();
        field.populate();

        int figureCount = 0;
        for(int x = 0; x < 12; x++){
            for(int y = 0; y < 8; y++){
                if(!field.isEmpty(new FieldCoordinate(0, x, y)))
                    figureCount++;
            }
        }

        assertEquals(18, figureCount);
    }
    @Test
    public void middleFigureCountTest(){
        Field field = new Field();
        field.populate();

        int figureCount = 0;
        for(int x = 0; x < 12; x++){
            for(int y = 0; y < 8; y++){
                if(!field.isEmpty(new FieldCoordinate(1, x, y)))
                    figureCount++;
            }
        }

        assertEquals(48, figureCount);
    }
    @Test
    public void downFigureCountTest(){
        Field field = new Field();
        field.populate();

        int figureCount = 0;
        for(int x = 0; x < 12; x++){
            for(int y = 0; y < 8; y++){
                if(!field.isEmpty(new FieldCoordinate(2, x, y)))
                    figureCount++;
            }
        }

        assertEquals(18, figureCount);
    }
}
