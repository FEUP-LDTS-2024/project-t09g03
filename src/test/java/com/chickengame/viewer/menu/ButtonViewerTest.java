package com.chickengame.viewer.menu;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.menus.ButtonViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.inOrder;

public class ButtonViewerTest
{
    private ImageLoader imageLoader;
    private GUI gui;
    private BasicTextImage image;
    private BasicTextImage selectedImage;
    private Button button;
    private Position position;

    @BeforeProperty
    void helper()
    {
        this.imageLoader = Mockito.mock(ImageLoader.class);
        this.gui = Mockito.mock(GUI.class);
        this.image = Mockito.mock(BasicTextImage.class);
        this.selectedImage = Mockito.mock(BasicTextImage.class);
        this.button = Mockito.mock(Button.class);
        this.position = Mockito.mock(Position.class);

        Mockito.when(button.getPosition()).thenReturn(position);
    }

    @Property
    void drawSelectedElement(@ForAll String path, @ForAll String selectedPath)
    {
        Assume.that(!path.equals(selectedPath));

        Mockito.when(button.isSelected()).thenReturn(true);

        Mockito.when(imageLoader.getImage(path)).thenReturn(image);
        Mockito.when(imageLoader.getImage(selectedPath)).thenReturn(selectedImage);

        InOrder inOrder = inOrder(gui,imageLoader);

        ButtonViewer buttonViewer = new ButtonViewer(imageLoader, path, selectedPath);

        inOrder.verify(imageLoader,calls(1)).getImage(path);
        inOrder.verify(imageLoader, calls(1)).getImage(selectedPath);

        buttonViewer.draw(gui, button);

        inOrder.verify(gui, calls(1)).drawImage(position, selectedImage);
        inOrder.verify(gui, Mockito.never()).drawImage(position, image);
    }

    @Property
    void drawNotSelectedElement(@ForAll String path, @ForAll String selectedPath)
    {
        Assume.that(!path.equals(selectedPath));

        Mockito.when(button.isSelected()).thenReturn(false);

        Mockito.when(imageLoader.getImage(path)).thenReturn(image);
        Mockito.when(imageLoader.getImage(selectedPath)).thenReturn(selectedImage);

        InOrder inOrder = inOrder(gui,imageLoader);

        ButtonViewer buttonViewer = new ButtonViewer(imageLoader, path, selectedPath);

        inOrder.verify(imageLoader,calls(1)).getImage(path);
        inOrder.verify(imageLoader, calls(1)).getImage(selectedPath);

        buttonViewer.draw(gui, button);

        inOrder.verify(gui, Mockito.never()).drawImage(position, selectedImage);
        inOrder.verify(gui, calls(1)).drawImage(position, image);
    }
}
