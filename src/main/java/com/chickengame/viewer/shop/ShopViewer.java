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
    private final Position posLeft = new Position(160,125);
    private final Position posMiddle = new Position(340,125);
    private final Position posRigth = new Position(510,125);
    private final BasicTextImage background = imageLoader.getImage("images/shop/Background_shop.png");
    private final List<BasicTextImage> Skins = new ArrayList<>();

    public ShopViewer(Shop location) {
        super(location);
        for(Button b : getLocation().getButtons())
        {
            buttonViewer.add(new ButtonViewer(b));
        }
        for(int i = 0; i<getLocation().getMaxChicken(); i++)
        {
            Skins.add(imageLoader.getImage("images/shop/chicken" + i + ".png"));
        }

    }

    @Override
    public void drawElements(GUI gui) {
        drawBackground(gui);
        for(ButtonViewer vb: buttonViewer)
        {
            vb.drawElements(gui);
        }
        gui.drawImage(posMiddle, Skins.get(getLocation().getCurrentChicken()));
        gui.drawImage(posRigth,  Skins.get((getLocation().getCurrentChicken()+1)< getLocation().getMaxChicken()? getLocation().getCurrentChicken()+1:0));
        gui.drawImage(posLeft, Skins.get((getLocation().getCurrentChicken()-1)< 0? getLocation().getMaxChicken()-1:getLocation().getCurrentChicken()-1));
    }
    private void drawBackground(GUI gui)
    {
        gui.drawImage(new Position(0,0),background);
    }
}
