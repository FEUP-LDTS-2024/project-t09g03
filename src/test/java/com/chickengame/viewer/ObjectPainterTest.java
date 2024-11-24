package com.chickengame.viewer;

import com.chickengame.controler.ImageHandler;
import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.image.BufferedImage;


public class ObjectPainterTest {
    private GUI gui;
    private ImageHandler image;
    private Element element;
    private ObjectPainter obj;
    private Position position;
    private BufferedImage buffer;


    @BeforeEach
    void helper()
    {
        this.gui = Mockito.mock(GUI.class);
        this.image = Mockito.mock(ImageHandler.class);
        this.element = Mockito.mock(Element.class);
        this.position = Mockito.mock(Position.class);
        this.buffer = Mockito.mock(BufferedImage.class);
        this.obj = new ObjectPainter();
    }
    @Test
    public void draw()
    {
        Mockito.when(this.element.getPosition()).thenReturn(this.position);
        Mockito.when(this.position.getX()).thenReturn(0);
        Mockito.when(this.position.getY()).thenReturn(0);

        Mockito.when(this.element.getImage()).thenReturn(this.buffer);
        Mockito.when(this.image.getSizeX(this.buffer)).thenReturn(2);
        Mockito.when(this.image.getSizeY(this.buffer)).thenReturn(2);
        Mockito.when(this.image.getColor(0, 0, this.buffer)).thenReturn("#FFFFFF");
        Mockito.when(this.image.getColor(0, 1, this.buffer)).thenReturn("#000000");
        Mockito.when(this.image.getColor(1, 0, this.buffer)).thenReturn("#FF0000");
        Mockito.when(this.image.getColor(1, 1, this.buffer)).thenReturn("#00FF00");

        obj.draw(this.gui, this.image, this.element);

        Mockito.verify(this.gui).draw(0, 0, "#FFFFFF");
        Mockito.verify(this.gui).draw(1, 0, "#FF0000");
        Mockito.verify(this.gui).draw(1, 1, "#00FF00");

        Mockito.verify(this.gui, Mockito.never()).draw(10, 21, "#000000");

        Mockito.verifyNoMoreInteractions(this.gui);
    }
}
