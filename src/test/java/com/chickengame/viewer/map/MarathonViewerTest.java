package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.Map;
import com.chickengame.model.game.map.MarathonMap;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.game.elements.ChickenViewer;
import com.chickengame.viewer.game.elements.ElementViewer;
import com.chickengame.viewer.game.map.MarathonViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class MarathonViewerTest {
    private MarathonViewer marathonViewer;
    private MarathonMap marathonMap;
    private GUI gui;
    private ElementViewerFactory elementViewerFactory;
    private ElementViewer elementViewer;
    private ChickenViewer chickenViewer;
    private Element element;
    private Chicken chicken;
    private Map map;
    private BasicTextImage basicTextImage;

    @BeforeEach
    public void helper()
    {
        this.basicTextImage = Mockito.mock(BasicTextImage.class);
        this.marathonMap = Mockito.mock(MarathonMap.class);
        this.gui = Mockito.mock(GUI.class);
        this.elementViewerFactory = Mockito.mock(ElementViewerFactory.class);
        this.elementViewer = Mockito.mock(ElementViewer.class);
        this.chickenViewer = Mockito.mock(ChickenViewer.class);
        this.element = Mockito.mock(Element.class);
        this.chicken = Mockito.mock(Chicken.class);
        this.map = Mockito.mock(Map.class);

        Mockito.when(elementViewerFactory.getBackground("background")).thenReturn(basicTextImage);
        Mockito.when(marathonMap.getCurrent()).thenReturn(map);
        Mockito.when(marathonMap.getNextMap()).thenReturn(map);
        Mockito.when(marathonMap.getChicken()).thenReturn(chicken);
        Mockito.when(elementViewerFactory.getViewer(any())).thenReturn(elementViewer);
        Mockito.when(elementViewerFactory.getChickenViewer(0)).thenReturn(chickenViewer);

        List<Element> elements = new ArrayList<>();
        elements.add(element);
        Mockito.when(map.getElements()).thenReturn(elements);

        this.marathonViewer = new MarathonViewer(marathonMap, elementViewerFactory);
    }

    @Test
    public void drawElements()
    {
        marathonViewer.drawElements(gui);

        Mockito.verify(elementViewer, Mockito.times(2)).draw(gui, element);
        Mockito.verify(chickenViewer, Mockito.times(1)).draw(gui, chicken);
        Mockito.verify(gui, Mockito.times(1)).drawImage(any(Position.class),any(BasicTextImage.class));
    }
}
