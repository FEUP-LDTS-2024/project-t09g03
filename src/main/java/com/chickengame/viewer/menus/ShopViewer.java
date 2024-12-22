package com.chickengame.viewer.menus;

import com.chickengame.gui.GUI;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.game.elements.ElementViewer;

public class ShopViewer extends MenuViewer<ShopMenu>
{
    private ElementViewerFactory elementViewerFactory;
    public ShopViewer(ShopMenu location, ButtonViewerFactory buttonViewerFactory, ElementViewerFactory elementViewerFactory)
    {
        super(location, buttonViewerFactory);
        this.elementViewerFactory = elementViewerFactory;
    }
    @Override
    protected void drawElements(GUI gui)
    {
        super.drawElements(gui);

        ElementViewer shopChickenMiddleViewer = elementViewerFactory.getShopChickenViewer(getLocation().getMiddleChicken().getName());
        ElementViewer shopChickenRightViewer = elementViewerFactory.getShopChickenViewer(getLocation().getRightChicken().getName());
        ElementViewer shopChickenLeftViewer = elementViewerFactory.getShopChickenViewer(getLocation().getLeftChicken().getName());

        shopChickenMiddleViewer.draw(gui,getLocation().getMiddleChicken());
        shopChickenRightViewer.draw(gui,getLocation().getRightChicken());
        shopChickenLeftViewer.draw(gui,getLocation().getLeftChicken());
    }
}
