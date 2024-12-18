package com.chickengame.viewer.map;

import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.map.elements.ChickenViewer;
import com.chickengame.viewer.map.elements.ElementViewer;
import com.chickengame.viewer.map.elements.InvertedElementViewer;

import java.util.HashMap;
import java.util.Map;

public class ElementViewerFactory
{

    private static final String backgroundPath = "images/game/background.png";
    private static final String candyCanePath = "images/game/candyCane.png";
    private static final String candyCaneDownPath = "images/game/candyCaneDown.png";
    private static final String chocolatePlatformPath = "images/game/chocolatePlatform.png";
    private static final String cookiePath = "images/game/cookie.png";
    private static final String cornSpikePath = "images/game/cornSpike.png";
    private static final String cornSpikeDownPath = "images/game/cornSpikeDown.png";
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

    private final String chickenMovingPath = "images/game/chicken/chickenMoving";
    private final String chickenStaticPath = "images/game/chicken/chickenStatic";
    private final String chickenMovingDownPath = "images/game/chicken/chickenMovingDown";
    private final String chickenStaticDownPath = "images/game/chicken/chickenStaticDown";

    private ImageLoader imgLoader = new ImageLoader();

    private Map<String, ElementViewer> cache = new HashMap<>();

    public ElementViewer getViewer(String name)
    {
        if(!cache.containsKey(name))
        {
            switch(name)
            {
                case "background":
                    cache.put("background", new ElementViewer(imgLoader,backgroundPath));
                    break;
                case "candyCane":
                    cache.put("candyCane", new InvertedElementViewer(imgLoader,candyCanePath,candyCaneDownPath));
                    break;
                case "chocolatePlatform":
                    cache.put("chocolatePlatform", new ElementViewer(imgLoader,chocolatePlatformPath));
                    break;
                case "cookie":
                    cache.put("cookie", new ElementViewer(imgLoader,cookiePath));
                    break;
                case "cornSpike":
                    cache.put("cornSpike", new InvertedElementViewer(imgLoader,cornSpikePath,cornSpikeDownPath));
                    break;
                case "cupcake":
                    cache.put("cupcake", new InvertedElementViewer(imgLoader,cupcakePath,cupcakeDownPath));
                    break;
                case "finishLine":
                    cache.put("finishLine", new ElementViewer(imgLoader,finishLinePath));
                    break;
                case "gummy":
                    cache.put("gummy", new InvertedElementViewer(imgLoader,gummyPath,gummyDownPath));
                    break;
                case "iceCream":
                    cache.put("iceCream", new InvertedElementViewer(imgLoader,iceCreamPath,iceCreamDownPath));
                    break;
                case "lollipop":
                    cache.put("lollipop", new InvertedElementViewer(imgLoader,lollipopPath,lollipopDownPath));
                    break;
                case "platform":
                    cache.put("platform", new ElementViewer(imgLoader,platformPath));
                    break;
                case "toblerone":
                    cache.put("toblerone", new InvertedElementViewer(imgLoader,tobleronePath,tobleroneDownPath));
                    break;
            }
        }
        return cache.get(name);
    }
    public ChickenViewer getChickenViewer(int skin)
    {
        return new ChickenViewer(imgLoader,chickenStaticPath+skin+".png",chickenStaticDownPath+skin+".png",chickenMovingPath+skin+".png",chickenMovingDownPath+skin+".png");
    }
}
