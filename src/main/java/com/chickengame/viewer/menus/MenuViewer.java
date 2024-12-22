package com.chickengame.viewer.menus;

import com.chickengame.model.menus.buttons.Button;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.elements.ElementViewer;

import java.util.List;

public class MenuViewer extends Viewer<Menu>
{
    private final ButtonViewerFactory buttonViewerFactory;
    private final ElementViewer backgroundViewer;
    private final List<Button> buttons;

    public MenuViewer(Menu location, ButtonViewerFactory viewerFactory)
    {
        super(location);
        buttonViewerFactory = viewerFactory;
        backgroundViewer = buttonViewerFactory.getViewer(getLocation().getBackground().getName());
        buttons = getLocation().getButtons();
    }

    @Override
    protected void drawElements(GUI gui)
    {
        backgroundViewer.draw(gui,getLocation().getBackground());
        for(Button button :  buttons)
        {
            ElementViewer buttonViewer = buttonViewerFactory.getViewer(button.getName());
            buttonViewer.draw(gui, button);
        }
    }

    public ButtonViewerFactory getButtonViewerFactory()
    {
        return buttonViewerFactory;
    }
}
