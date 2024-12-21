package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.LevelMap;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.elements.ChickenViewer;
import com.chickengame.viewer.elements.ElementViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;


public class LevelViewerTest {
    private LevelViewer levelViewer;
    private GUI gui;
    private MapViewer mapViewer;
    private ElementViewer backgroundViewer;
    private ElementViewer finishLineViewer;
    private ChickenViewer chickenViewer;
    private ElementViewerFactory elementViewerFactory;
    private LevelMap location;
    private Element element;
    private BasicTextImage image;
    private Chicken chicken;
    private Position position;
    private Map map;
    private List<Element> elements;

    @BeforeEach
    public void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.mapViewer = Mockito.mock(MapViewer.class);
        this.backgroundViewer = Mockito.mock(ElementViewer.class);
        this.finishLineViewer = Mockito.mock(ElementViewer.class);
        this.chickenViewer = Mockito.mock(ChickenViewer.class);
        this.elementViewerFactory = Mockito.mock(ElementViewerFactory.class);
        this.location = Mockito.mock(LevelMap.class);
        this.element = Mockito.mock(Element.class);
        this.image = Mockito.mock(BasicTextImage.class);
        this.chicken = Mockito.mock(Chicken.class);
        this.position = Mockito.mock(Position.class);
        this.map = Mockito.mock(Map.class);

        Mockito.when(location.getBackground()).thenReturn(element);
        Mockito.when(location.getFinishLine()).thenReturn(element);
        Mockito.when(location.getChicken()).thenReturn(chicken);

        Mockito.when(elementViewerFactory.getChickenViewer(0)).thenReturn(chickenViewer);
        Mockito.when(elementViewerFactory.getViewer("background")).thenReturn(backgroundViewer);
        Mockito.when(elementViewerFactory.getViewer("finishLine")).thenReturn(finishLineViewer);
        Mockito.when(elementViewerFactory.getViewer(any())).thenReturn(backgroundViewer);

        Mockito.when(element.getPosition()).thenReturn(position);
        Mockito.when(element.getName()).thenReturn("name");

        List<Element> elements = new ArrayList<>();
        elements.add(element);
        Mockito.when(map.getElements()).thenReturn(elements);
        Mockito.when(location.getMap()).thenReturn(map);

        this.levelViewer = new LevelViewer(location);
    }

    @Test
    public void drawElements() throws IOException {
        levelViewer.draw(gui);

        Mockito.verify(backgroundViewer, Mockito.times(1)).draw(gui, element);
        Mockito.verify(finishLineViewer, Mockito.times(1)).draw(gui, element);
        Mockito.verify(chickenViewer, Mockito.times(1)).draw(gui, chicken);
        Mockito.verify(mapViewer, Mockito.times(1)).drawElements(gui);
    }
}
