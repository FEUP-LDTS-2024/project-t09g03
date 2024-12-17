package com.chickengame.viewer.map;

import com.chickengame.model.Position;
import com.chickengame.viewer.ImageLoader;
import com.googlecode.lanterna.graphics.BasicTextImage;

import java.util.HashMap;
import java.util.Map;

public class ElementViewerFactory
{
    //cuidado com a situacao da chicken!!!!
    private static final String backgroundPath = "images/game/background.png";
    private static final String candyCanePath = "images/game/candyCane.png";
    private static final String candyCaneDownPath = "images/game/candyCaneDown.png";
    private static final String chocolatePlatformPath = "images/game/chocolatePlatform.png";
    private static final String cookiePath = "images/game/cookie.png";
    private static final String cornspikePath = "images/game/cornspike.png";
    private static final String cornspikeDownPath = "images/game/cornspikeDown.png";
    private static final String cupcakePath = "images/game/cupcake.png";
    private static final String cupcakeDownPath = "images/game/cupcakeDown.png";
    private static final String finishLinePath = "images/game/finishLine.png";
    private static final String gummyPath = "images/game/gummy.png";
    private static final String gummyDownPath = "images/game/gummyDown.png";
    private static final String iceCreamPath = "images/game/iceCream.png";
    private static final String iceCreamDownPath = "images/game/iceCreamDown.png";
    private static final String lollipopPath = "images/game/lollipop.png";
    private static final String lollipopDownPath = "images/game/lollipopDown.png";
    private static final String platformPath = "images/game/platform.png";
    private static final String tobleronePath = "images/game/toblerone.png";
    private static final String tobleroneDownPath = "images/game/tobleroneDown.png";

    private ImageLoader imgLoader = new ImageLoader();

    private HashMap<String,ElementViewer> cache = new HashMap<String, ElementViewer>();

    public void drawElements(String name, Position position)
    {
        switch (name)
        {
            case "background":
                cache["background"].draw(position,backgroundPath);



        }
    }
    public void drawElements(String name, Position position, Boolean inverted)
    {
        switch (name)
        {
            case "cupccake":




        }
    }
}
