package com.chickengame.viewer;

import com.chickengame.model.menus.buttons.Button;
import com.chickengame.viewer.menus.ButtonViewer;

import java.util.HashMap;
import java.util.Map;

public class ButtonViewerFactory extends ViewerFactory<Button>
{

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

    private Map<String, ButtonViewer> cache = new HashMap<>();


    public ButtonViewerFactory(ImageLoader imageLoader) {
        super(imageLoader);
    }


    @Override
    public ButtonViewer getViewer(String name)
    {
        if(!cache.containsKey(name))
        {
            switch(name)
            {
                case "Back":
                    cache.put(name, new ButtonViewer(imgLoader,backButtonPath,backButtonPressedPath));
                    break;
                case "Help":
                    cache.put(name,new ButtonViewer(imgLoader,helpButtonPath,helpButtonPressedPath));
                    break;
                case "Level1":
                    cache.put(name, new ButtonViewer(imgLoader, level1ButtonPath, level1ButtonPressedPath));
                    break;
                case "Level2":
                    cache.put(name, new ButtonViewer(imgLoader, level2ButtonPath, level2ButtonPressedPath));
                    break;
                case "Level3":
                    cache.put(name, new ButtonViewer(imgLoader, level3ButtonPath, level3ButtonPressedPath));
                    break;
                case "LevelMenu":
                    cache.put(name, new ButtonViewer(imgLoader, levelButtonPath, levelPressedButtonPath));
                    break;
                case "Next":
                    cache.put(name, new ButtonViewer(imgLoader,nextButtonPath,nextButtonPressedPath));
                    break;
                case "Play":
                    cache.put(name, new ButtonViewer(imgLoader, playButtonPath, playButtonPressedPath));
                    break;
                case "Previous":
                    cache.put(name, new ButtonViewer(imgLoader,previousButtonPath,previousButtonPressedPath));
                    break;
                case "Exit":
                    cache.put(name, new ButtonViewer(imgLoader,quitButtonPath,quitButtonPressedPath));
                    break;
                case "Shop":
                    cache.put(name, new ButtonViewer(imgLoader,shopButtonPath,shopButtonPressedPath));
                    break;
                default:
                    throw new RuntimeException("Invalid button!");
            }
        }
        return cache.get(name);
    }

}
