package com.chickengame.viewer.game.elements;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Chicken;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.game.elements.ChickenViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.inOrder;

public class ChickenViewerTest
{
    private BasicTextImage imgMoving;
    private BasicTextImage imgMovingDown;
    private BasicTextImage imgStatic;
    private BasicTextImage imgStaticDown;
    private Chicken chicken;
    private ImageLoader imgLoader;
    private GUI gui;
    private Position position;

    @BeforeProperty
    void helper()
    {
        this.imgMoving = Mockito.mock(BasicTextImage.class);
        this.imgMovingDown = Mockito.mock(BasicTextImage.class);
        this.imgStatic = Mockito.mock(BasicTextImage.class);
        this.imgStaticDown = Mockito.mock(BasicTextImage.class);
        this.chicken = Mockito.mock(Chicken.class);
        this.imgLoader = Mockito.mock(ImageLoader.class);
        this.gui = Mockito.mock(GUI.class);
        this.position = Mockito.mock(Position.class);

        Mockito.when(chicken.getPosition()).thenReturn(position);
    }

    @Property
    void drawStatic(@ForAll String path, @ForAll String invertedPath, @ForAll String movingPath, @ForAll String movingDownPath)
    {
        Assume.that(!path.equals(invertedPath));
        Assume.that(!path.equals(movingPath));
        Assume.that(!path.equals(movingDownPath));
        Assume.that(!invertedPath.equals(movingPath));
        Assume.that(!invertedPath.equals(movingDownPath));
        Assume.that(!movingPath.equals(movingDownPath));

        Mockito.when(chicken.isInverted()).thenReturn(false);
        Mockito.when(chicken.isWalking()).thenReturn(false);

        Mockito.when(imgLoader.getImage(path)).thenReturn(imgStatic);
        Mockito.when(imgLoader.getImage(invertedPath)).thenReturn(imgStaticDown);
        Mockito.when(imgLoader.getImage(movingPath)).thenReturn(imgMoving);
        Mockito.when(imgLoader.getImage(movingDownPath)).thenReturn(imgMovingDown);

        InOrder inOrder = inOrder(gui,imgLoader);

        ChickenViewer chickenViewer = new ChickenViewer(imgLoader,path,invertedPath,movingPath,movingDownPath);

        inOrder.verify(imgLoader,calls(1)).getImage(path);
        inOrder.verify(imgLoader, calls(1)).getImage(invertedPath);
        inOrder.verify(imgLoader, calls(1)).getImage(movingPath);
        inOrder.verify(imgLoader, calls(1)).getImage(movingDownPath);

        chickenViewer.draw(gui, chicken);

        inOrder.verify(gui, calls(1)).drawImage(position, imgStatic);
        inOrder.verify(gui, Mockito.never()).drawImage(position, imgStaticDown);
        inOrder.verify(gui, Mockito.never()).drawImage(position, imgMoving);
        inOrder.verify(gui, Mockito.never()).drawImage(position, imgMovingDown);
    }

    @Property
    void drawStaticDown(@ForAll String path, @ForAll String invertedPath, @ForAll String movingPath, @ForAll String movingDownPath)
    {
        Assume.that(!path.equals(invertedPath));
        Assume.that(!path.equals(movingPath));
        Assume.that(!path.equals(movingDownPath));
        Assume.that(!invertedPath.equals(movingPath));
        Assume.that(!invertedPath.equals(movingDownPath));
        Assume.that(!movingPath.equals(movingDownPath));

        Mockito.when(chicken.isInverted()).thenReturn(true);
        Mockito.when(chicken.isWalking()).thenReturn(false);

        Mockito.when(imgLoader.getImage(path)).thenReturn(imgStatic);
        Mockito.when(imgLoader.getImage(invertedPath)).thenReturn(imgStaticDown);
        Mockito.when(imgLoader.getImage(movingPath)).thenReturn(imgMoving);
        Mockito.when(imgLoader.getImage(movingDownPath)).thenReturn(imgMovingDown);

        InOrder inOrder = inOrder(gui,imgLoader);

        ChickenViewer chickenViewer = new ChickenViewer(imgLoader,path,invertedPath,movingPath,movingDownPath);

        inOrder.verify(imgLoader,calls(1)).getImage(path);
        inOrder.verify(imgLoader, calls(1)).getImage(invertedPath);
        inOrder.verify(imgLoader, calls(1)).getImage(movingPath);
        inOrder.verify(imgLoader, calls(1)).getImage(movingDownPath);

        chickenViewer.draw(gui, chicken);

        inOrder.verify(gui, Mockito.never()).drawImage(position, imgStatic);
        inOrder.verify(gui, calls(1)).drawImage(position, imgStaticDown);
        inOrder.verify(gui, Mockito.never()).drawImage(position, imgMoving);
        inOrder.verify(gui, Mockito.never()).drawImage(position, imgMovingDown);
    }

    @Property
    void drawMoving(@ForAll String path, @ForAll String invertedPath, @ForAll String movingPath, @ForAll String movingDownPath)
    {
        Assume.that(!path.equals(invertedPath));
        Assume.that(!path.equals(movingPath));
        Assume.that(!path.equals(movingDownPath));
        Assume.that(!invertedPath.equals(movingPath));
        Assume.that(!invertedPath.equals(movingDownPath));
        Assume.that(!movingPath.equals(movingDownPath));

        Mockito.when(chicken.isInverted()).thenReturn(false);
        Mockito.when(chicken.isWalking()).thenReturn(true);

        Mockito.when(imgLoader.getImage(path)).thenReturn(imgStatic);
        Mockito.when(imgLoader.getImage(invertedPath)).thenReturn(imgStaticDown);
        Mockito.when(imgLoader.getImage(movingPath)).thenReturn(imgMoving);
        Mockito.when(imgLoader.getImage(movingDownPath)).thenReturn(imgMovingDown);

        InOrder inOrder = inOrder(gui,imgLoader);

        ChickenViewer chickenViewer = new ChickenViewer(imgLoader,path,invertedPath,movingPath,movingDownPath);

        inOrder.verify(imgLoader,calls(1)).getImage(path);
        inOrder.verify(imgLoader, calls(1)).getImage(invertedPath);
        inOrder.verify(imgLoader, calls(1)).getImage(movingPath);
        inOrder.verify(imgLoader, calls(1)).getImage(movingDownPath);

        chickenViewer.draw(gui, chicken);

        inOrder.verify(gui, Mockito.never()).drawImage(position, imgStatic);
        inOrder.verify(gui, Mockito.never()).drawImage(position, imgStaticDown);
        inOrder.verify(gui, calls(1)).drawImage(position, imgMoving);
        inOrder.verify(gui, Mockito.never()).drawImage(position, imgMovingDown);
    }

    @Property
    void drawMovingDown(@ForAll String path, @ForAll String invertedPath, @ForAll String movingPath, @ForAll String movingDownPath)
    {
        Assume.that(!path.equals(invertedPath));
        Assume.that(!path.equals(movingPath));
        Assume.that(!path.equals(movingDownPath));
        Assume.that(!invertedPath.equals(movingPath));
        Assume.that(!invertedPath.equals(movingDownPath));
        Assume.that(!movingPath.equals(movingDownPath));

        Mockito.when(chicken.isInverted()).thenReturn(true);
        Mockito.when(chicken.isWalking()).thenReturn(true);

        Mockito.when(imgLoader.getImage(path)).thenReturn(imgStatic);
        Mockito.when(imgLoader.getImage(invertedPath)).thenReturn(imgStaticDown);
        Mockito.when(imgLoader.getImage(movingPath)).thenReturn(imgMoving);
        Mockito.when(imgLoader.getImage(movingDownPath)).thenReturn(imgMovingDown);

        InOrder inOrder = inOrder(gui,imgLoader);

        ChickenViewer chickenViewer = new ChickenViewer(imgLoader,path,invertedPath,movingPath,movingDownPath);

        inOrder.verify(imgLoader,calls(1)).getImage(path);
        inOrder.verify(imgLoader, calls(1)).getImage(invertedPath);
        inOrder.verify(imgLoader, calls(1)).getImage(movingPath);
        inOrder.verify(imgLoader, calls(1)).getImage(movingDownPath);

        chickenViewer.draw(gui, chicken);

        inOrder.verify(gui, Mockito.never()).drawImage(position, imgStatic);
        inOrder.verify(gui, Mockito.never()).drawImage(position, imgStaticDown);
        inOrder.verify(gui, Mockito.never()).drawImage(position, imgMoving);
        inOrder.verify(gui, calls(1)).drawImage(position, imgMovingDown);
    }
}
