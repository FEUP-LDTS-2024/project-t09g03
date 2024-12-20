package com.chickengame.viewer.menus;

import com.chickengame.gui.GUI;
import com.chickengame.model.menus.Menu;
import com.chickengame.model.menus.ShopMenu;
import com.chickengame.viewer.elements.ElementViewer;

public class ShopViewer extends MenuViewer
{
    public ShopViewer(Menu location)
    {
        super(location);
    }
    @Override
    protected void drawElements(GUI gui)
    {
        super.drawElements(gui);

        ShopMenu location = (ShopMenu)getLocation();
        ElementViewer shopChickenMiddleViewer = super.getElementViewerFactory().getShopChickenViewer(location.getMiddleChicken().getName());
        ElementViewer shopChickenRightViewer = super.getElementViewerFactory().getShopChickenViewer(location.getRightChicken().getName());
        ElementViewer shopChickenLeftViewer = super.getElementViewerFactory().getShopChickenViewer(location.getLeftChicken().getName());

        shopChickenMiddleViewer.draw(gui,location.getMiddleChicken());
        shopChickenRightViewer.draw(gui,location.getRightChicken());
        shopChickenLeftViewer.draw(gui,location.getLeftChicken());
    }
}
