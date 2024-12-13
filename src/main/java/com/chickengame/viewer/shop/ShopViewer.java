package com.chickengame.viewer.shop;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.menu.Button;
import com.chickengame.model.game.shop.Shop;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.Viewer;
import com.chickengame.viewer.menu.ButtonViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

import java.util.ArrayList;
import java.util.List;

public class ShopViewer extends Viewer<Shop> {
    private ImageLoader imageLoader = new ImageLoader();
    private List<ButtonViewer> buttonViewer = new ArrayList<>();
    private final BasicTextImage background = imageLoader.getImage("images/shop/Background_shop.png");

    public ShopViewer(Shop location) {
        super(location);
        for(Button b : getLocation().getButtons())
        {
            buttonViewer.add(new ButtonViewer(b));
        }
    }

    @Override
    public void drawElements(GUI gui) {
        drawBackground(gui);
        for(ButtonViewer vb: buttonViewer)
        {
            vb.drawElements(gui);
        }
    }
    private void drawBackground(GUI gui)
    {
        gui.drawImage(new Position(0,0),background);
    }
}
