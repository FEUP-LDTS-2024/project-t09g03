package com.chickengame.viewer;

import com.chickengame.model.game.elements.Element;
import com.chickengame.model.menus.Menu;
import com.chickengame.viewer.elements.ElementViewer;
import com.chickengame.viewer.elements.InvertedElementViewer;

import java.util.HashMap;
import java.util.Map;

public class ButtonViewerFactory extends ViewerFactory<Menu>{

    private static final String backButtonPath = "images/menus/buttons/backButton.png";
    private static final String backButtonPressedPath = "images/menus/buttons/backButtonPressed.png";
    private static final String helpButtonPath = "images/menus/buttons/helpButton.png";
    private static final String helpButtonPressedPath = "images/menus/buttons/helpButtonPressed.png";
    private static final String level1ButtonPath = "images/menus/buttons/level1Button.png";
    private static final String level1ButtonPressedPath = "images/menus/buttons/level1ButtonPressed.png";
    private static final String level2ButtonPath = "images/menus/buttons/level2Button.png";
    private static final String level2ButtonPressedPath = "images/menus/buttons/level2ButtonPressed.png";
    private static final String level3ButtonPath = "images/menus/buttons/level3Button.png";
    private static final String level3ButtonPressedPath = "images/menus/buttons/level3ButtonPressed.png";
    private static final String levelButtonPath = "images/menus/buttons/levelButton.png";
    private static final String levelPressedButtonPath = "images/menus/buttons/levelButtonPressed.png";
    private static final String nextButtonPath = "images/menus/buttons/nextButton.png";
    private static final String nextButtonPressedPath = "images/menus/buttons/nextButtonPressed.png";
    private static final String playButtonPath = "images/menus/buttons/playButton.png";
    private static final String playButtonPressedPath = "images/menus/buttons/playButtonPressed.png";
    private static final String previousButtonPath = "images/menus/buttons/previousButton.png";
    private static final String previousButtonPressedPath = "images/menus/buttons/previousButtonPressed.png";
    private static final String quitButtonPath = "images/menus/buttons/quitButton.png";
    private static final String quitButtonPressedPath = "images/menus/buttons/quitButtonPressed.png";
    private static final String shopButtonPath = "images/menus/buttons/shopButton.png";
    private static final String shopButtonPressedPath = "images/menus/buttons/shopButtonPressed.png";

    private static final String chickenShopPath = "images/menus/chickens/";


    private Map<String, ElementViewer> cache = new HashMap<>();


    public ButtonViewerFactory(ImageLoader imageLoader) {
        super(imageLoader);
    }


    @Override
    public ElementViewer getViewer(String name)
    {
        if(super.getViewer(name)!= null)return super.getViewer(name);
        if(!cache.containsKey(name))
        {
            switch(name)
            {
                case "backButton":
                    cache.put(name, new InvertedElementViewer(imgLoader,backButtonPath,backButtonPressedPath));
                    break;
                case "helpButton":
                    cache.put(name,new InvertedElementViewer(imgLoader,helpButtonPath,helpButtonPressedPath));
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
                case "nextButton":
                    cache.put(name, new InvertedElementViewer(imgLoader,nextButtonPath,nextButtonPressedPath));
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
                case "shopButton":
                    cache.put(name, new InvertedElementViewer(imgLoader,shopButtonPath,shopButtonPressedPath));
                    break;
            }
        }
        return cache.get(name);
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
