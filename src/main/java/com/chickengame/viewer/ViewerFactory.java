package com.chickengame.viewer;

import com.googlecode.lanterna.graphics.BasicTextImage;

public abstract class ViewerFactory<T>
{
    private static final String backgroundPath = "images/game/background.png";
    private static final String gameOverBackgroundPath = "images/menus/backgrounds/gameOverBackground.png";
    private static final String helpBackgroundPath = "images/menus/backgrounds/helpBackground.png";
    private static final String mainBackgroundPath = "images/menus/backgrounds/mainBackground.png";
    private static final String shopBackgroundPath = "images/menus/backgrounds/shopBackground.png";
    private static final String winBackgroundPath = "images/menus/backgrounds/winBackground.png";

    protected ImageLoader imgLoader;

    ViewerFactory(ImageLoader imageLoader)
    {
        this.imgLoader = imageLoader;
    }
    public BasicTextImage getBackground(String name)
    {
        return switch (name) {
            case "gameOverBackground" -> imgLoader.getImage(gameOverBackgroundPath);
            case "helpBackground" -> imgLoader.getImage(helpBackgroundPath);
            case "mainBackground" -> imgLoader.getImage(mainBackgroundPath);
            case "shopBackground" -> imgLoader.getImage(shopBackgroundPath);
            case "winBackground" -> imgLoader.getImage(winBackgroundPath);
            default -> imgLoader.getImage(backgroundPath);
        };
    }
    public abstract ObjectViewer<T> getViewer(String name);
}
