package com.chickengame.viewer.map;

import com.chickengame.gui.GUI;
import com.chickengame.model.game.elements.Cookie;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class CookieViewer implements ElementViewer<Cookie>
{
    private ImageLoader imgLoader = new ImageLoader();
    private BasicTextImage imgCookie = imgLoader.getImage("images/game/cookie.png");

    @Override
    public void draw(Cookie cookie, GUI gui)
    {
        gui.drawImage(cookie.getPosition(),imgCookie);
    }
}
