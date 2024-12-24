package com.chickengame.viewer;

import com.chickengame.viewer.menus.ButtonViewer;
import net.jqwik.api.*;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;

public class ButtonViewerFactoryTest
{
    private ImageLoader imageLoader;
    private ButtonViewerFactory buttonViewerFactory;

    @BeforeEach
    @BeforeProperty
    void helper()
    {
        this.imageLoader = Mockito.mock(ImageLoader.class);
        this.buttonViewerFactory = new ButtonViewerFactory(imageLoader);
    }

    @Test
    void getBackButton()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Back");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/backButton.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/backButtonPressed.png");
    }

    @Test
    void getHelpButton()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Help");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/helpButton.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/helpButtonPressed.png");
    }

    @Test
    void getLevel1Button()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Level1");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/level1Button.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/level1ButtonPressed.png");
    }

    @Test
    void getLevel2Button()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Level2");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/level2Button.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/level2ButtonPressed.png");
    }

    @Test
    void getLevel3Button()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Level3");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/level3Button.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/level3ButtonPressed.png");
    }

    @Test
    void getLevelMenuButton()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("LevelMenu");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/levelButton.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/levelButtonPressed.png");
    }

    @Test
    void getNextButton()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Next");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/nextButton.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/nextButtonPressed.png");
    }

    @Test
    void getPlayButton()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Play");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/playButton.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/playButtonPressed.png");
    }

    @Test
    void getPreviousButton()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Previous");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/previousButton.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/previousButtonPressed.png");
    }

    @Test
    void getExitButton()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Exit");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/quitButton.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/quitButtonPressed.png");
    }

    @Test
    void getShopButton()
    {
        ButtonViewer buttonViewer = buttonViewerFactory.getViewer("Shop");

        assertNotNull(buttonViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/shopButton.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/buttons/shopButtonPressed.png");
    }

    @Provide
    Arbitrary<String> validButtonNames()
    {
        return Arbitraries.of("Back","Help", "Level1", "Level2", "Level3","LevelMenu", "Next", "Previous", "Play", "Exit", "Shop");
    }

    @Provide
    Arbitrary<String> invalidButtonNames()
    {
        Set<String> validButtons = Set.of("Back", "Help", "Level1", "Level2", "Level3",
                "LevelMenu", "Next", "Previous", "Play", "Exit", "Shop");
        return Arbitraries.strings().filter(name -> !validButtons.contains(name));
    }

    @Property
    public void testCache(@ForAll("validButtonNames") String name)
    {
        InOrder inOrder = inOrder(imageLoader);
        ButtonViewer viewer1 = buttonViewerFactory.getViewer(name);
        ButtonViewer viewer2 = buttonViewerFactory.getViewer(name);

        assertSame(viewer1, viewer2);

        inOrder.verify(imageLoader, Mockito.calls(2)).getImage(Mockito.any());
    }

    @Property
    public void testInvalidButtons(@ForAll("invalidButtonNames") String name)
    {
        assertThrows(RuntimeException.class, () -> buttonViewerFactory.getViewer(name));
    }
}
