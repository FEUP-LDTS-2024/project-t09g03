package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Element;
import com.chickengame.model.game.map.Map;
import com.chickengame.viewer.Viewer;

import java.util.List;

public class MapViewer extends Viewer<Map> {

    private final CupcakeViewer cupcakeViewer = new CupcakeViewer();
    private final PlatformViewer platformViewer = new PlatformViewer();
    private final CornspikeViewer cornspikeViewer = new CornspikeViewer();
    private final LollipopViewer lollipopViewer = new LollipopViewer();

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
        System.out.println(element.getPosition().getX()+ " " + element.getPosition().getY());
        viewer.draw(element,gui);
    }
}
