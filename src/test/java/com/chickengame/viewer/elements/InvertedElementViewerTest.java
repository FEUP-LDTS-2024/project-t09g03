package com.chickengame.viewer.map.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.InvertedElement;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.game.elements.InvertedElementViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class InvertedElementViewerTest {
    private ImageLoader imgLoader;
    private GUI gui;
    private BasicTextImage image;
    private InvertedElement isInverted;
    private InvertedElement isNotInverted;
    private Position position;

    @BeforeEach
    void helper()
    {
        this.imgLoader = Mockito.mock(ImageLoader.class);
        this.gui = Mockito.mock(GUI.class);
        this.image = Mockito.mock(BasicTextImage.class);
        this.isInverted = Mockito.mock(InvertedElement.class);
        this.isNotInverted = Mockito.mock(InvertedElement.class);
        this.position = Mockito.mock(Position.class);

        Mockito.when(isInverted.getPosition()).thenReturn(position);
        Mockito.when(isNotInverted.getPosition()).thenReturn(position);
        Mockito.when(isInverted.isInverted()).thenReturn(true);
        Mockito.when(isNotInverted.isInverted()).thenReturn(false);
        Mockito.when(imgLoader.getImage(any())).thenReturn(this.image);
    }

    @Test
    void drawInvertedElement()
    {
        InvertedElementViewer invertedElementViewer = new InvertedElementViewer(imgLoader, "images/game/lollipop.png", "images/game/lollipopDown.png");
        invertedElementViewer.draw(gui, isInverted);

        Mockito.verify(gui, Mockito.times(1)).drawImage(isInverted.getPosition(), this.image);
    }

    @Test
    void drawNotInvertedElement()
    {
        InvertedElementViewer nonInvertedElementViewer = new InvertedElementViewer(imgLoader, "images/game/lollipop.png", "images/game/lollipopDown.png");
        nonInvertedElementViewer.draw(gui, isNotInverted);

        Mockito.verify(gui, Mockito.times(1)).drawImage(isNotInverted.getPosition(), this.image);
    }
}
