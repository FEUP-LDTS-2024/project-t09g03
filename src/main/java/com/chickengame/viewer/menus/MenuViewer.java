package com.chickengame.viewer.menus;

import com.chickengame.model.menus.buttons.Button;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.elements.ElementViewer;

import java.util.List;

public class MenuViewer extends Viewer<Menu>
{
    private final ElementViewerFactory elementViewerFactory;
    private final ElementViewer backgroundViewer;
    private final List<Button> buttons;

    public MenuViewer(Menu location, ElementViewerFactory elementViewerFactory)
    {
        super(location);
        this.elementViewerFactory = elementViewerFactory;
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
