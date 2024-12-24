package com.chickengame.viewer;

import com.googlecode.lanterna.graphics.BasicTextImage;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ViewerFactoryTest
{
    private ImageLoader imageLoader;
    private BasicTextImage background;
    private BasicTextImage gameOverBackground;
    private BasicTextImage helpBackground;
    private BasicTextImage mainBackground;
    private BasicTextImage shopBackground;
    private BasicTextImage winBackground;
    private ElementViewerFactory elementViewerFactory;
    private ButtonViewerFactory buttonViewerFactory;

    @BeforeEach
    @BeforeProperty
    public void helper()
    {
        this.imageLoader = Mockito.mock(ImageLoader.class);
        this.background = Mockito.mock(BasicTextImage.class);
        this.gameOverBackground = Mockito.mock(BasicTextImage.class);
        this.helpBackground = Mockito.mock(BasicTextImage.class);
        this.mainBackground = Mockito.mock(BasicTextImage.class);
        this.shopBackground = Mockito.mock(BasicTextImage.class);
        this.winBackground = Mockito.mock(BasicTextImage.class);

        Mockito.when(imageLoader.getImage("images/game/background.png")).thenReturn(background);
        Mockito.when(imageLoader.getImage("images/menus/backgrounds/gameOverBackground.png")).thenReturn(gameOverBackground);
        Mockito.when(imageLoader.getImage("images/menus/backgrounds/helpBackground.png")).thenReturn(helpBackground);
        Mockito.when(imageLoader.getImage("images/menus/backgrounds/mainBackground.png")).thenReturn(mainBackground);
        Mockito.when(imageLoader.getImage("images/menus/backgrounds/shopBackground.png")).thenReturn(shopBackground);
        Mockito.when(imageLoader.getImage("images/menus/backgrounds/winBackground.png")).thenReturn(winBackground);

        this.buttonViewerFactory = new ButtonViewerFactory(imageLoader);
        this.elementViewerFactory = new ElementViewerFactory(imageLoader);
    }

    @Test
    public void getBackground()
    {
        assertEquals(elementViewerFactory.getBackground("gameOverBackground"), gameOverBackground);
        assertEquals(buttonViewerFactory.getBackground("gameOverBackground"), gameOverBackground);

        assertEquals(elementViewerFactory.getBackground("helpBackground"), helpBackground);
        assertEquals(buttonViewerFactory.getBackground("helpBackground"), helpBackground);

        assertEquals(elementViewerFactory.getBackground("mainBackground"), mainBackground);
        assertEquals(buttonViewerFactory.getBackground("mainBackground"), mainBackground);

        assertEquals(elementViewerFactory.getBackground("shopBackground"), shopBackground);
        assertEquals(buttonViewerFactory.getBackground("shopBackground"), shopBackground);

        assertEquals(elementViewerFactory.getBackground("winBackground"), winBackground);
        assertEquals(buttonViewerFactory.getBackground("winBackground"), winBackground);

    }

    @Property
    public void getBackground(@ForAll String name)
    {
        Assume.that(!name.equals("gameOverBackground"));
        Assume.that(!name.equals("helpBackground"));
        Assume.that(!name.equals("mainBackground"));
        Assume.that(!name.equals("shopBackground"));
        Assume.that(!name.equals("winBackground"));

        assertEquals(elementViewerFactory.getBackground(name), background);
        assertEquals(buttonViewerFactory.getBackground(name), background);
    }
}
