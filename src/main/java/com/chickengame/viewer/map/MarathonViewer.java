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

    public MarathonViewer(Map map)
    {
        super(map);
    }
    @Override
    public void drawElements(GUI gui)
    {
        this.drawElements(gui,getLocation().getBackground(),backgroundViewer);
        this.drawElements(gui,getLocation().getChicken(), chickenViewer);
        this.drawElements(gui,getLocation().getPlatforms(), platformViewer);
        this.drawElements(gui,getLocation().getCornspikes(), cornspikeViewer);
        this.drawElements(gui,getLocation().getCupcakes(), cupcakeViewer);
        this.drawElements(gui,getLocation().getLollipops(),lollipopViewer);
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
