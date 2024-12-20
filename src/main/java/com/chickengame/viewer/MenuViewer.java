package com.chickengame.viewer;

import com.chickengame.model.menu.Button;
import com.chickengame.gui.GUI;
import com.chickengame.model.Menu;
import com.chickengame.viewer.map.ElementViewerFactory;
import com.chickengame.viewer.map.elements.ElementViewer;

import java.util.List;

public class MenuViewer extends Viewer<Menu>
{
    private final ElementViewerFactory elementViewerFactory;
    private final ElementViewer backgroundViewer;
    private final List<Button> buttons;

    public MenuViewer(Menu location)
    {
        super(location);
        elementViewerFactory = new ElementViewerFactory();
        backgroundViewer = elementViewerFactory.getViewer(getLocation().getBackground().getName());
        buttons = getLocation().getButtons();
    }

    @Override
    protected void drawElements(GUI gui)
    {
        backgroundViewer.draw(gui,getLocation().getBackground());
        for(Button button :  buttons)
        {
            ElementViewer buttonViewer = elementViewerFactory.getViewer(button.getName());
            buttonViewer.draw(gui, button);
        }
    }

    public ElementViewerFactory getElementViewerFactory()
    {
        return elementViewerFactory;
    }
}
