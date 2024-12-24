package com.chickengame.viewer.game.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.InvertedElement;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.inOrder;

public class InvertedElementViewerTest
{
    private ImageLoader imgLoader;
    private GUI gui;
    private BasicTextImage image;
    private BasicTextImage invertedImage;
    private InvertedElement element;
    private Position position;

    @BeforeProperty
    void helper()
    {
        this.imgLoader = Mockito.mock(ImageLoader.class);
        this.gui = Mockito.mock(GUI.class);
        this.image = Mockito.mock(BasicTextImage.class);
        this.invertedImage = Mockito.mock(BasicTextImage.class);
        this.element = Mockito.mock(InvertedElement.class);
        this.position = Mockito.mock(Position.class);

        Mockito.when(element.getPosition()).thenReturn(position);
    }

    @Property
    void drawInvertedElement(@ForAll String path, @ForAll String invertedPath)
    {
        Assume.that(!path.equals(invertedPath));

        Mockito.when(element.isInverted()).thenReturn(true);

        Mockito.when(imgLoader.getImage(path)).thenReturn(image);
        Mockito.when(imgLoader.getImage(invertedPath)).thenReturn(invertedImage);

        InOrder inOrder = inOrder(gui,imgLoader);

        InvertedElementViewer invertedElementViewer = new InvertedElementViewer(imgLoader, path, invertedPath);

        inOrder.verify(imgLoader,calls(1)).getImage(path);
        inOrder.verify(imgLoader, calls(1)).getImage(invertedPath);

        invertedElementViewer.draw(gui, element);

        inOrder.verify(gui, calls(1)).drawImage(position, invertedImage);
        inOrder.verify(gui, Mockito.never()).drawImage(position, image);
    }

    @Property
    void drawNotInvertedElement(@ForAll String path, @ForAll String invertedPath)
    {
        Assume.that(!path.equals(invertedPath));

        Mockito.when(element.isInverted()).thenReturn(false);

        Mockito.when(imgLoader.getImage(path)).thenReturn(image);
        Mockito.when(imgLoader.getImage(invertedPath)).thenReturn(invertedImage);

        InOrder inOrder = inOrder(gui,imgLoader);

        InvertedElementViewer invertedElementViewer = new InvertedElementViewer(imgLoader, path, invertedPath);

        inOrder.verify(imgLoader,calls(1)).getImage(path);
        inOrder.verify(imgLoader, calls(1)).getImage(invertedPath);

        invertedElementViewer.draw(gui, element);

        inOrder.verify(gui, calls(1)).drawImage(position, image);
        inOrder.verify(gui, Mockito.never()).drawImage(position, invertedImage);
    }
}
