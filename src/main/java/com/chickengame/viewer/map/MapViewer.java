package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.map.elements.*;

import java.util.List;

public class MapViewer extends Viewer<Map> {

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


    public MapViewer(Map location) {
        super(location);
    }

    @Override
    protected void drawElements(GUI gui)
    {
        this.drawElements(gui,getLocation().getPlatforms(), platformViewer);
        this.drawElements(gui,getLocation().getCornspikes(), cornspikeViewer);
        this.drawElements(gui,getLocation().getCupcakes(), cupcakeViewer);
        this.drawElements(gui,getLocation().getLollipops(),lollipopViewer);
        this.drawElements(gui, getLocation().getGummies(), gummyViewer);
        this.drawElements(gui, getLocation().getCandyCanes(), candyCaneViewer);
        this.drawElements(gui, getLocation().getIcecreams(), iceCreamViewer);
        this.drawElements(gui, getLocation().getCookies(), cookieViewer);
        this.drawElements(gui, getLocation().getToblerones(), tobleroneViewer);
        this.drawElements(gui, getLocation().getChocolatePlatforms(), chocolatePlatformViewer);

    }



    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer)
    {
        for(T element : elements)
        {
            viewer.draw(element,gui);
        }
    }
    private <T extends Element> void drawElements(GUI gui, T element, ElementViewer<T> viewer)
    {
        viewer.draw(element,gui);
    }
}
