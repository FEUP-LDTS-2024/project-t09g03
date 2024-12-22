package com.chickengame.viewer.menus;

import com.chickengame.model.Position;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.menus.buttons.ButtonLevel;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.Viewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

import java.util.List;

public class MenuViewer<T extends Menu> extends Viewer<T>
{
    private final ButtonViewerFactory buttonViewerFactory;
    private final BasicTextImage backgroundBasicTextImage;
    private final List<Button> buttons;

    public MenuViewer(T location, ButtonViewerFactory viewerFactory)
    {
        super(location);
        buttonViewerFactory = viewerFactory;
        System.out.println(location.getBackground());
        backgroundBasicTextImage = viewerFactory.getBackground(location.getBackground());
        buttons = getLocation().getButtons();
    }

    @Override
    protected void drawElements(GUI gui)
    {
        gui.drawImage(new Position(0,0),backgroundBasicTextImage);
        for(Button button :  buttons)
        {
            String name = button.getType().toString();
            if(button.getType() == Button.Type.Level)
            {
                name += ((ButtonLevel)button).getLevel();
            }
            ButtonViewer buttonViewer = buttonViewerFactory.getViewer(name);
            buttonViewer.draw(gui,button);
        }
    }
}
