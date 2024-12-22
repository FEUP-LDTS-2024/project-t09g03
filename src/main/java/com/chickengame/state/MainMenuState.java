package com.chickengame.state;
import com.chickengame.controller.menus.MainMenuController;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.ButtonViewerFactory;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.menus.MenuViewer;

public class MainMenuState extends State<Menu>
{
    public MainMenuState(Menu location)
    {
        super(location);
    }

    @Override
    public MenuViewer getStateViewer()
    {
        return new MenuViewer(getLocation(),new ButtonViewerFactory(new ImageLoader()));
    }

    @Override
    public MainMenuController getStateController()
    {
        return new MainMenuController(getLocation());
    }
}
