package com.chickengame.viewer.menu;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.menu.Button;
import com.chickengame.model.game.menu.Menu;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.Viewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

import java.util.ArrayList;
import java.util.List;

public class MenuViewer extends Viewer<Menu> {
    private ImageLoader imageLoader = new ImageLoader();
    private List<ButtonViewer> buttonViewer = new ArrayList<>();
    private final BasicTextImage background = imageLoader.getImage("images/menu/Background_menu.png");

    public MenuViewer(Menu location) {
        super(location);
        for(Button b : getLocation().getButtons())
        {
            buttonViewer.add(new ButtonViewer(b));
        }
    }


    @Override
    public void drawElements(GUI gui) {
        drawBackground(gui);
        /*for(ButtonViewer vb: buttonViewer)
        {
            vb.drawElements(gui);
        }*/
    }
    private void drawBackground(GUI gui)
    {
        gui.drawImage(new Position(0,0),background);
    }
}
