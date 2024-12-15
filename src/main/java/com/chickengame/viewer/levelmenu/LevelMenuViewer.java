package com.chickengame.viewer.levelmenu;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.menu.Button;
import com.chickengame.model.levelmenu.LevelMenu;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.menu.ButtonViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

import java.util.ArrayList;
import java.util.List;

public class LevelMenuViewer extends Viewer<LevelMenu> {

    private final List<ButtonViewer> buttonViewers = new ArrayList<>();
    private final BasicTextImage background =  super.getImageLoader().getImage("images/shop/Background_shop.png");

    public LevelMenuViewer(LevelMenu location) {
        super(location);
        for(Button b : getLocation().getButtons())
        {
            buttonViewers.add(new ButtonViewer(b));
        }
    }

    @Override
    protected void drawElements(GUI gui)
    {
        gui.drawImage(new Position(0,0),background);
        for(ButtonViewer vb : buttonViewers)
        {
            vb.drawElements(gui);
        }
    }
}
