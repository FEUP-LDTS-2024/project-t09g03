package com.chickengame.viewer;

import com.chickengame.viewer.game.elements.ChickenViewer;
import com.chickengame.viewer.game.elements.ElementViewer;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;

public class ElementViewerFactoryTest
{
    private ImageLoader imageLoader;
    private ElementViewerFactory elementViewerFactory;

    @BeforeEach
    @BeforeProperty
    void helper()
    {
        this.imageLoader = Mockito.mock(ImageLoader.class);
        this.elementViewerFactory = new ElementViewerFactory(imageLoader);
    }


    @Test
    void getCandyCane()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("candyCane");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/candyCane.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/candyCaneDown.png");
    }

    @Test
    void getChocolatePlatform()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("chocolatePlatform");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/chocolatePlatform.png");
    }

    @Test
    void getCookie()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("cookie");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/cookie.png");
    }

    @Test
    void getCornSpikes()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("cornSpike");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/cornSpike.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/cornSpikeDown.png");
    }

    @Test
    void getCupcake()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("cupcake");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/cupcake.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/cupcakeDown.png");
    }

    @Test
    void getFinishLine()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("finishLine");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/finishLine.png");
    }

    @Test
    void getGummy()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("gummy");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/gummy.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/gummyDown.png");
    }

    @Test
    void getIceCream()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("iceCream");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/iceCream.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/iceCreamDown.png");
    }

    @Test
    void getLollipopPath()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("lollipop");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/lollipop.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/lollipopDown.png");
    }

    @Test
    void getPlatform()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("platform");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/platform.png");
    }

    @Test
    void getToblerone()
    {
        ElementViewer elementViewer = elementViewerFactory.getViewer("toblerone");

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/toblerone.png");
        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/game/tobleroneDown.png");
    }

    @Provide
    Arbitrary<String> validElementNames()
    {
        return Arbitraries.of("candyCane", "chocolatePlatform", "cookie", "cornSpike", "cupcake", "finishLine", "gummy", "iceCream", "lollipop", "platform", "toblerone");
    }

    @Provide
    Arbitrary<String> invalidElementNames()
    {
        Set<String> validElements = Set.of("candyCane", "chocolatePlatform", "cookie", "cornSpike", "cupcake", "finishLine", "gummy", "iceCream", "lollipop", "platform", "toblerone");
        return Arbitraries.strings().filter(name -> !validElements.contains(name));
    }

    @Property
    public void testCache(@ForAll("validElementNames") String name)
    {
        InOrder inOrder = inOrder(imageLoader);

        ElementViewer viewer1 = elementViewerFactory.getViewer(name);
        ElementViewer viewer2 = elementViewerFactory.getViewer(name);

        assertSame(viewer1, viewer2);

        inOrder.verify(imageLoader, Mockito.calls(2)).getImage(Mockito.any());
    }

    @Property
    public void testInvalidButtons(@ForAll("invalidElementNames") String name)
    {
        assertThrows(RuntimeException.class, () -> elementViewerFactory.getViewer(name));
    }

    @Property
    public void getChickenViewer(@ForAll @IntRange (min = 0, max = 8)int skin)
    {
        ChickenViewer chickenViewer = elementViewerFactory.getChickenViewer(skin);

        assertNotNull(chickenViewer);

        InOrder inOrder = inOrder(imageLoader);

        inOrder.verify(imageLoader,Mockito.calls(1)).getImage("images/game/chicken/chickenStatic" + skin + ".png");
        inOrder.verify(imageLoader,Mockito.calls(1)).getImage("images/game/chicken/chickenStaticDown" + skin + ".png");
        inOrder.verify(imageLoader,Mockito.calls(1)).getImage("images/game/chicken/chickenMoving" + skin + ".png");
        inOrder.verify(imageLoader,Mockito.calls(1)).getImage("images/game/chicken/chickenMovingDown" + skin + ".png");

    }

    @Property
    public void getShopChickenViewer(@ForAll @IntRange (min = 0, max = 8)int skin)
    {
        String name = "chicken"+ skin;
        ElementViewer elementViewer = elementViewerFactory.getShopChickenViewer(name);

        assertNotNull(elementViewer);

        Mockito.verify(imageLoader,Mockito.times(1)).getImage("images/menus/chickens/" + name + ".png");
    }

    @Provide
    Arbitrary<String> validChickenNames()
    {
        return Arbitraries.of("chicken0", "chicken1","chicken2","chicken3","chicken4","chicken5","chicken6","chicken7","chicken8");
    }

    @Property
    public void testChickenCache(@ForAll("validChickenNames") String name)
    {
        InOrder inOrder = inOrder(imageLoader);

        ElementViewer viewer1 = elementViewerFactory.getShopChickenViewer(name);
        ElementViewer viewer2 = elementViewerFactory.getShopChickenViewer(name);

        assertSame(viewer1, viewer2);

        inOrder.verify(imageLoader, Mockito.calls(1)).getImage("images/menus/chickens/" + name + ".png");
    }
}
