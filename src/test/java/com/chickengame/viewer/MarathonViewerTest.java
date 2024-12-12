package com.chickengame.viewer;

import com.chickengame.controller.ImageHandler;
import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.model.game.elements.HarmObject;
import com.chickengame.model.game.elements.Wall;
import com.chickengame.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class MarathonViewerTest {
    private GUI gui;
    private Map map;
    private MarathonViewer marathonviewer;
    private  ImageHandler imageHandler;
    private ObjectPainter painter;

    @BeforeEach
    void helper() throws IOException {
        this.map = Mockito.mock(Map.class);
        this.gui = Mockito.mock(GUI.class);
        this.imageHandler = Mockito.mock(ImageHandler.class);
        this.painter = Mockito.mock(ObjectPainter.class);
        this.marathonviewer = new MarathonViewer(this.gui,this.map, this.imageHandler, this.painter);
    }

    @Test
    void drawMap()
    {
        Mockito.when(map.getWalls()).thenReturn(Arrays.asList(Mockito.mock(Wall.class),Mockito.mock(Wall.class)));
        Mockito.when(map.getBackground()).thenReturn(Mockito.mock(Background.class));
        Mockito.when(map.getHarmObjects()).thenReturn(Arrays.asList(Mockito.mock(HarmObject.class),Mockito.mock(HarmObject.class)));
        Mockito.when(map.getChicken()).thenReturn(Mockito.mock(Chicken.class));
        marathonviewer.drawMap();

        Mockito.verify(painter, Mockito.times(6)).draw(Mockito.eq(gui),Mockito.eq(imageHandler), Mockito.any());
    }
}
