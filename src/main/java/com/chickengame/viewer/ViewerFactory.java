package com.chickengame.viewer;

import com.chickengame.viewer.elements.ElementViewer;
import com.chickengame.viewer.elements.InvertedElementViewer;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class ViewerFactory<T> {
    private static final String backgroundPath = "images/game/background.png";
    private static final String gameOverBackgroundPath = "images/menus/backgrounds/gameOverBackground.png";
    private static final String helpBackgroundPath = "images/menus/backgrounds/helpBackground.png";
    private static final String mainBackgroundPath = "images/menus/backgrounds/mainBackground.png";
    private static final String shopBackgroundPath = "images/menus/backgrounds/shopBackground.png";
    private static final String winBackgroundPath = "images/menus/backgrounds/winBackground.png";


    protected ImageLoader imgLoader;
    private Map<String, ElementViewer> cache = new HashMap<>();




    ViewerFactory(ImageLoader imageLoader)
    {
        this.imgLoader = imageLoader;
    }

    public ElementViewer getViewer(String name)
    {
        if(!cache.containsKey(name))
        {
            switch(name)
            {
                case "background":
                    cache.put(name, new ElementViewer(imgLoader,backgroundPath));
                break;
                case "gameEndBackground":
                    cache.put(name,new InvertedElementViewer(imgLoader,winBackgroundPath,gameOverBackgroundPath));
                    break;
                case "helpBackground":
                    cache.put(name, new ElementViewer(imgLoader,helpBackgroundPath));
                break;
                case "mainBackground":
                    cache.put(name, new ElementViewer(imgLoader,mainBackgroundPath));
                    break;
                case "shopBackground":
                    cache.put(name, new ElementViewer(imgLoader,shopBackgroundPath));
                    break;
            }
        }
        return cache.get(name);
    }
}
