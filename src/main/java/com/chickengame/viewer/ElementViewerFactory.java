package com.chickengame.viewer;

import com.chickengame.model.game.map.GameMode;
import com.chickengame.viewer.elements.ChickenViewer;
import com.chickengame.viewer.elements.ElementViewer;
import com.chickengame.viewer.elements.InvertedElementViewer;

import java.util.HashMap;
import java.util.Map;

public class ElementViewerFactory extends ViewerFactory<GameMode>
{
    private static final String backButtonPath = "images/menus/buttons/backButton.png";
    private static final String backButtonPressedPath = "images/menus/buttons/backButtonPressed.png";
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
    private static final String helpButtonPath = "images/menus/buttons/helpButton.png";
    private static final String helpButtonPressedPath = "images/menus/buttons/helpButtonPressed.png";
    private static final String iceCreamPath = "images/game/iceCream.png";
    private static final String iceCreamDownPath = "images/game/iceCreamDown.png";
    private static final String level1ButtonPath = "images/menus/buttons/level1Button.png";
    private static final String level1ButtonPressedPath = "images/menus/buttons/level1ButtonPressed.png";
    private static final String level2ButtonPath = "images/menus/buttons/level2Button.png";
    private static final String level2ButtonPressedPath = "images/menus/buttons/level2ButtonPressed.png";
    private static final String level3ButtonPath = "images/menus/buttons/level3Button.png";
    private static final String level3ButtonPressedPath = "images/menus/buttons/level3ButtonPressed.png";
    private static final String levelButtonPath = "images/menus/buttons/levelButton.png";
    private static final String levelPressedButtonPath = "images/menus/buttons/levelButtonPressed.png";
    private static final String lollipopPath = "images/game/lollipop.png";
    private static final String lollipopDownPath = "images/game/lollipopDown.png";
    private static final String nextButtonPath = "images/menus/buttons/nextButton.png";
    private static final String nextButtonPressedPath = "images/menus/buttons/nextButtonPressed.png";
    private static final String platformPath = "images/game/platform.png";
    private static final String playButtonPath = "images/menus/buttons/playButton.png";
    private static final String playButtonPressedPath = "images/menus/buttons/playButtonPressed.png";
    private static final String previousButtonPath = "images/menus/buttons/previousButton.png";
    private static final String previousButtonPressedPath = "images/menus/buttons/previousButtonPressed.png";
    private static final String quitButtonPath = "images/menus/buttons/quitButton.png";
    private static final String quitButtonPressedPath = "images/menus/buttons/quitButtonPressed.png";
    private static final String shopButtonPath = "images/menus/buttons/shopButton.png";
    private static final String shopButtonPressedPath = "images/menus/buttons/shopButtonPressed.png";
    private static final String tobleronePath = "images/game/toblerone.png";
    private static final String tobleroneDownPath = "images/game/tobleroneDown.png";

    private static final String chickenMovingPath = "images/game/chicken/chickenMoving";
    private static final String chickenStaticPath = "images/game/chicken/chickenStatic";
    private static final String chickenMovingDownPath = "images/game/chicken/chickenMovingDown";
    private static final String chickenStaticDownPath = "images/game/chicken/chickenStaticDown";


    private Map<String, ElementViewer> cache = new HashMap<>();

    public ElementViewerFactory(ImageLoader imageLoader)
    {
        super(imageLoader);
    }
    public ElementViewer getViewer(String name)
    {
        if(super.getViewer(name)!= null)return super.getViewer(name);
        if(!cache.containsKey(name))
        {
            switch(name)
            {
                case "candyCane":
                    cache.put(name, new InvertedElementViewer(imgLoader,candyCanePath,candyCaneDownPath));
                    break;
                case "chocolatePlatform":
                    cache.put(name, new ElementViewer(imgLoader,chocolatePlatformPath));
                    break;
                case "cookie":
                    cache.put(name, new ElementViewer(imgLoader,cookiePath));
                    break;
                case "cornSpike":
                    cache.put(name, new InvertedElementViewer(imgLoader,cornSpikePath,cornSpikeDownPath));
                    break;
                case "cupcake":
                    cache.put(name, new InvertedElementViewer(imgLoader,cupcakePath,cupcakeDownPath));
                    break;
                case "finishLine":
                    cache.put(name, new ElementViewer(imgLoader,finishLinePath));
                    break;
                case "gummy":
                    cache.put(name, new InvertedElementViewer(imgLoader,gummyPath,gummyDownPath));
                    break;
                case "iceCream":
                    cache.put(name, new InvertedElementViewer(imgLoader,iceCreamPath,iceCreamDownPath));
                    break;
                case "lollipop":
                    cache.put(name, new InvertedElementViewer(imgLoader,lollipopPath,lollipopDownPath));
                    break;
                case "platform":
                    cache.put(name, new ElementViewer(imgLoader,platformPath));
                    break;
                case "toblerone":
                    cache.put(name, new InvertedElementViewer(imgLoader,tobleronePath,tobleroneDownPath));
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