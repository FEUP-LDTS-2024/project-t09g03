package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.*;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.*;

import java.util.ArrayList;
import java.util.List;

public class MarathonViewer extends Viewer<Map>
{
    private final ChickenViewer chickenViewer = new ChickenViewer(getLocation().getChicken().getType());
    private final BackgroundViewer backgroundViewer = new BackgroundViewer();
    private final CupcakeViewer cupcakeViewer = new CupcakeViewer();
    private final PlatformViewer platformViewer = new PlatformViewer();
    private final CornspikeViewer cornspikeViewer = new CornspikeViewer();
    private final LollipopViewer lollipopViewer = new LollipopViewer();
    private final GummyViewer gummyViewer = new GummyViewer();
    private final CandyCaneViewer candyCaneViewer = new CandyCaneViewer();
    private final IceCreamViewer iceCreamViewer = new IceCreamViewer();
    private final CookieViewer cookieViewer = new CookieViewer();
    private final TobleroneViewer tobleroneViewer = new TobleroneViewer();
    private final ChocolatePlatformViewer chocolatePlatformViewer = new ChocolatePlatformViewer();



    public MarathonViewer(Map map)
    {
        super(map);
    }
    @Override
    public void drawElements(GUI gui)
    {
        drawElements(gui,getLocation().getBackground(),backgroundViewer);
        drawElements(gui,getLocation().getPlatforms(), platformViewer);
        drawElements(gui,getLocation().getCornspikes(), cornspikeViewer);
        drawElements(gui,getLocation().getCupcakes(), cupcakeViewer);
        drawElements(gui,getLocation().getLollipops(),lollipopViewer);
        drawElements(gui,getLocation().getGummies(),gummyViewer);
        drawElements(gui,getLocation().getCandyCanes(),candyCaneViewer);
        drawElements(gui,getLocation().getIcecreams(), iceCreamViewer);
        drawElements(gui,getLocation().getCookies(), cookieViewer);
        drawElements(gui,getLocation().getToblerones(), tobleroneViewer);
        drawElements(gui, getLocation().getChocolatePlatforms(), chocolatePlatformViewer);
        drawElements(gui,getLocation().getChicken(), chickenViewer);
    }
    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer)
    {
        for(T element : elements)
        {
            viewer.draw(element,gui);
        }
    }
    private <T extends Element> void drawElements(GUI gui, T elements, ElementViewer<T> viewer)
    {
        viewer.draw(elements,gui);
    }
}
