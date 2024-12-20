package com.chickengame.model.map;

import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MapTest {
    private Chicken chicken;
    private List<Element> harmObjects;
    private List<Element> walls;
    private List<Element> elements;


    @BeforeEach
    void helper()
    {
        this.chicken = Mockito.mock(Chicken.class);

    }

    @Test
    void collidesUp()
    {

    }
}
