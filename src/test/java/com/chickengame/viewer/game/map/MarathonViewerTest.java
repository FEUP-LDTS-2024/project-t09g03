package com.chickengame.viewer.game.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.Map;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.game.elements.ChickenViewer;
import com.chickengame.viewer.game.elements.ElementViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class MarathonViewerTest
{
    private MarathonViewer marathonViewer;
    private MarathonMap marathonMap;
    private GUI gui;
    private ElementViewerFactory elementViewerFactory;
    private ElementViewer elementViewer;
    private ElementViewer elementViewer2;
    private ChickenViewer chickenViewer;
    private Element element;
    private Chicken chicken;
    private Map currentMap;
    private Map nextMap;
    private BasicTextImage basicTextImage;
    private Element element2;

    @BeforeEach
    public void helper()
    {
        this.basicTextImage = Mockito.mock(BasicTextImage.class);
        this.marathonMap = Mockito.mock(MarathonMap.class);
        this.gui = Mockito.mock(GUI.class);
        this.elementViewerFactory = Mockito.mock(ElementViewerFactory.class);
        this.elementViewer = Mockito.mock(ElementViewer.class);
        this.elementViewer2 = Mockito.mock(ElementViewer.class);
        this.chickenViewer = Mockito.mock(ChickenViewer.class);
        this.element = Mockito.mock(Element.class);
        this.element2 = Mockito.mock(Element.class);
        this.chicken = Mockito.mock(Chicken.class);
        this.currentMap = Mockito.mock(Map.class);
        this.nextMap = Mockito.mock(Map.class);

        Mockito.when(elementViewerFactory.getBackground("background")).thenReturn(basicTextImage);

        Mockito.when(marathonMap.getCurrent()).thenReturn(currentMap);
        Mockito.when(marathonMap.getNextMap()).thenReturn(nextMap);

        Mockito.when(element.getName()).thenReturn("name");
        Mockito.when(element2.getName()).thenReturn("name2");

        Mockito.when(marathonMap.getChicken()).thenReturn(chicken);
        Mockito.when(elementViewerFactory.getViewer("name")).thenReturn(elementViewer);
        Mockito.when(elementViewerFactory.getViewer("name2")).thenReturn(elementViewer2);
        Mockito.when(elementViewerFactory.getChickenViewer(0)).thenReturn(chickenViewer);

        List<Element> currentElements = new ArrayList<>();
        currentElements.add(element);

        Mockito.when(currentMap.getElements()).thenReturn(currentElements);

        List<Element> nextElements = new ArrayList<>();
        nextElements.add(element2);
        Mockito.when(nextMap.getElements()).thenReturn(nextElements);

        this.marathonViewer = new MarathonViewer(marathonMap, elementViewerFactory);
    }

    @Test
    public void drawElements() throws IOException {
        marathonViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawImage(any(Position.class),any(BasicTextImage.class));
        Mockito.verify(elementViewer, Mockito.times(1)).draw(gui, element);
        Mockito.verify(elementViewer2, Mockito.times(1)).draw(gui, element2);
        Mockito.verify(chickenViewer, Mockito.times(1)).draw(gui, chicken);

        Mockito.verify(gui, Mockito.times(1)).refresh();

    }
}
