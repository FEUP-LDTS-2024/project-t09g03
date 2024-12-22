package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.elements.ChickenViewer;
import com.chickengame.viewer.elements.InvertedElementViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ChickenViewerTest {
    private BasicTextImage imgMoving;
    private BasicTextImage imgMovingDown;
    private Chicken chicken;
    private ImageLoader imgLoader;
    private GUI gui;
    private ChickenViewer chickenViewer;
    private InvertedElementViewer invertedElementViewer;
    private Position position;

    @BeforeEach
    void helper()
    {
        this.imgMoving = Mockito.mock(BasicTextImage.class);
        this.imgMovingDown = Mockito.mock(BasicTextImage.class);
        this.chicken = Mockito.mock(Chicken.class);
        this.imgLoader = Mockito.mock(ImageLoader.class);
        this.gui = Mockito.mock(GUI.class);
        this.invertedElementViewer = Mockito.mock(InvertedElementViewer.class);
        this.position = Mockito.mock(Position.class);

        Mockito.when(chicken.getPosition()).thenReturn(position);
        Mockito.when(imgLoader.getImage("images/game/chicken/chickenMoving")).thenReturn(imgMoving);
        Mockito.when(imgLoader.getImage("images/game/chicken/chickenMovingDown")).thenReturn(imgMovingDown);
        Mockito.when(imgLoader.getImage("images/game/chicken/chickenStatic")).thenReturn(imgMoving);
        Mockito.when(imgLoader.getImage("images/game/chicken/chickenStaticDown")).thenReturn(imgMovingDown);

        this.chickenViewer = new ChickenViewer(imgLoader, "images/game/chicken/chickenStatic", "images/game/chicken/chickenStaticDown","images/game/chicken/chickenMoving", "images/game/chicken/chickenMovingDown");

    }

    @Test
    void drawMoving()
    {
        Mockito.when(chicken.isWalking()).thenReturn(true);
        Mockito.when(chicken.isInverted()).thenReturn(false);

        chickenViewer.draw(gui, chicken);

        Mockito.verify(gui, Mockito.times(1)).drawImage(chicken.getPosition(), imgMoving);
    }

    @Test
    void drawMovingDown()
    {
        Mockito.when(chicken.isWalking()).thenReturn(true);
        Mockito.when(chicken.isInverted()).thenReturn(true);

        chickenViewer.draw(gui, chicken);

        Mockito.verify(gui, Mockito.times(1)).drawImage(chicken.getPosition(), imgMovingDown);
    }

    @Test
    void drawStatic()
    {
        Mockito.when(chicken.isWalking()).thenReturn(false);
        Mockito.when(chicken.isInverted()).thenReturn(false);

        chickenViewer.draw(gui, chicken);

        Mockito.verify(gui, Mockito.times(1)).drawImage(chicken.getPosition(), imgMoving);
    }

    @Test
    void drawStaticDown()
    {
        Mockito.when(chicken.isWalking()).thenReturn(false);
        Mockito.when(chicken.isInverted()).thenReturn(true);

        chickenViewer.draw(gui, chicken);

        Mockito.verify(gui, Mockito.times(1)).drawImage(chicken.getPosition(), imgMovingDown);
    }

}
