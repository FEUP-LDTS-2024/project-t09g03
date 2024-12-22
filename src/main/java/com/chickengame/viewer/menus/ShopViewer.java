package com.chickengame.viewer.menus;

import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ElementViewerFactory;
import com.chickengame.viewer.elements.ElementViewer;

public class ShopViewer extends MenuViewer
{
    private ElementViewerFactory elementViewerFactory;
    public ShopViewer(Menu location, ButtonViewerFactory buttonViewerFactory, ElementViewerFactory elementViewerFactory)
    {
        super(location, buttonViewerFactory);
        this.elementViewerFactory = elementViewerFactory;
    }
    @Override
    protected void drawElements(GUI gui)
    {
        super.drawElements(gui);

        ShopMenu location = (ShopMenu)getLocation();
        ElementViewer shopChickenMiddleViewer = elementViewerFactory.getShopChickenViewer(location.getMiddleChicken().getName());
        ElementViewer shopChickenRightViewer = elementViewerFactory.getShopChickenViewer(location.getRightChicken().getName());
        ElementViewer shopChickenLeftViewer = elementViewerFactory.getShopChickenViewer(location.getLeftChicken().getName());

        shopChickenMiddleViewer.draw(gui,location.getMiddleChicken());
        shopChickenRightViewer.draw(gui,location.getRightChicken());
        shopChickenLeftViewer.draw(gui,location.getLeftChicken());
    }
}
