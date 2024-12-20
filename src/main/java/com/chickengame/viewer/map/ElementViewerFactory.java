package com.chickengame.viewer.map;

import com.chickengame.model.game.elements.InvertedElement;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.map.elements.ChickenViewer;
import com.chickengame.viewer.map.elements.ElementViewer;
import com.chickengame.viewer.map.elements.InvertedElementViewer;

import java.util.HashMap;
import java.util.Map;

public class ElementViewerFactory
{
    private static final String backButtonPath = "images/shop/backButton.png";
    private static final String backButtonPressedPath = "images/shop/backButtonPressed.png";
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
    private static final String gameOverPath = "images/menu/gameEnd/gameOver.png";
    private static final String gummyPath = "images/game/gummy.png";
    private static final String gummyDownPath = "images/game/gummyDown.png";
    private static final String helpBackgroundPath = "images/menu/helpBackground.png";
    private static final String helpButtonPath = "images/menu/helpButton.png";
    private static final String helpButtonPressedPath = "images/menu/helpButtonPressed.png";
    private static final String iceCreamPath = "images/game/iceCream.png";
    private static final String iceCreamDownPath = "images/game/iceCreamDown.png";
    private static final String level1ButtonPath = "images/menu/levelMenu/level1Button.png";
    private static final String level1ButtonPressedPath = "images/menu/levelMenu/level1ButtonPressed.png";
    private static final String level2ButtonPath = "images/menu/levelMenu/level2Button.png";
    private static final String level2ButtonPressedPath = "images/menu/levelMenu/level2ButtonPressed.png";
    private static final String level3ButtonPath = "images/menu/levelMenu/level3Button.png";
    private static final String level3ButtonPressedPath = "images/menu/levelMenu/level3ButtonPressed.png";
    private static final String levelButtonPath = "images/menu/levelButton.png";
    private static final String levelPressedButtonPath = "images/menu/levelButtonPressed.png";
    private static final String lollipopPath = "images/game/lollipop.png";
    private static final String lollipopDownPath = "images/game/lollipopDown.png";
    private static final String mainBackgroundPath = "images/menu/mainBackground.png";
    private static final String nextButtonPath = "images/shop/nextButton.png";
    private static final String nextButtonPressedPath = "images/shop/nextButtonPressed.png";
    private static final String platformPath = "images/game/platform.png";
    private static final String playButtonPath = "images/menu/playButton.png";
    private static final String playButtonPressedPath = "images/menu/playButtonPressed.png";
    private static final String previousButtonPath = "images/shop/previousButton.png";
    private static final String previousButtonPressedPath = "images/shop/previousButtonPressed.png";
    private static final String quitButtonPath = "images/menu/quitButton.png";
    private static final String quitButtonPressedPath = "images/menu/quitButtonPressed.png";
    private static final String shopBackgroundPath = "images/shop/shopBackground.png";
    private static final String shopButtonPath = "images/menu/shopButton.png";
    private static final String shopButtonPressedPath = "images/menu/shopButtonPressed.png";
    private static final String tobleronePath = "images/game/toblerone.png";
    private static final String tobleroneDownPath = "images/game/tobleroneDown.png";
    private static final String winPath = "images/menu/gameEnd/win.png";

    private static final String chickenMovingPath = "images/game/chicken/chickenMoving";
    private static final String chickenStaticPath = "images/game/chicken/chickenStatic";
    private static final String chickenMovingDownPath = "images/game/chicken/chickenMovingDown";
    private static final String chickenStaticDownPath = "images/game/chicken/chickenStaticDown";

    private static final String chickenShopPath = "images/shop/";



    private ImageLoader imgLoader = new ImageLoader();

    private Map<String, ElementViewer> cache = new HashMap<>();

    public ElementViewer getViewer(String name)
    {
        if(!cache.containsKey(name))
        {
            switch(name)
            {
                case "backButton":
                    cache.put(name, new InvertedElementViewer(imgLoader,backButtonPath,backButtonPressedPath));
                    break;
                case "background":
                    cache.put(name, new ElementViewer(imgLoader,backgroundPath));
                    break;
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
                case "gameEndBackground":
                    cache.put(name,new InvertedElementViewer(imgLoader,winPath,gameOverPath));
                    break;
                case "gummy":
                    cache.put(name, new InvertedElementViewer(imgLoader,gummyPath,gummyDownPath));
                    break;
                case "helpBackground":
                    cache.put(name, new ElementViewer(imgLoader,helpBackgroundPath));
                    break;
                case "helpButton":
                    cache.put(name,new InvertedElementViewer(imgLoader,helpButtonPath,helpButtonPressedPath));
                    break;
                case "iceCream":
                    cache.put(name, new InvertedElementViewer(imgLoader,iceCreamPath,iceCreamDownPath));
                    break;
                case "level1Button":
                    cache.put(name, new InvertedElementViewer(imgLoader, level1ButtonPath, level1ButtonPressedPath));
                    break;
                case "level2Button":
                    cache.put(name, new InvertedElementViewer(imgLoader, level2ButtonPath, level2ButtonPressedPath));
                    break;
                case "level3Button":
                    cache.put(name, new InvertedElementViewer(imgLoader, level3ButtonPath, level3ButtonPressedPath));
                    break;
                case "levelButton":
                    cache.put(name, new InvertedElementViewer(imgLoader, levelButtonPath, levelPressedButtonPath));
                    break;
                case "lollipop":
                    cache.put(name, new InvertedElementViewer(imgLoader,lollipopPath,lollipopDownPath));
                    break;
                case "mainBackground":
                    cache.put(name, new ElementViewer(imgLoader,mainBackgroundPath));
                    break;
                case "nextButton":
                    cache.put(name, new InvertedElementViewer(imgLoader,nextButtonPath,nextButtonPressedPath));
                    break;
                case "platform":
                    cache.put(name, new ElementViewer(imgLoader,platformPath));
                    break;
                case "playButton":
                    cache.put(name, new InvertedElementViewer(imgLoader, playButtonPath, playButtonPressedPath));
                    break;
                case "previousButton":
                    cache.put(name, new InvertedElementViewer(imgLoader,previousButtonPath,previousButtonPressedPath));
                    break;
                case "quitButton":
                    cache.put(name, new InvertedElementViewer(imgLoader,quitButtonPath,quitButtonPressedPath));
                    break;
                case "shopBackground":
                    cache.put(name, new ElementViewer(imgLoader,shopBackgroundPath));
                    break;
                case "shopButton":
                    cache.put(name, new InvertedElementViewer(imgLoader,shopButtonPath,shopButtonPressedPath));
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

    public ElementViewer getShopChickenViewer(String name)
    {
        if(!cache.containsKey(name))
        {
            cache.put(name,new ElementViewer(imgLoader,chickenShopPath +name+ ".png"));
        }
        return cache.get(name);
    }
}
