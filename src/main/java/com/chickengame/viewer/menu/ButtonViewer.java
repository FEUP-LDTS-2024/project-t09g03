package com.chickengame.viewer.menu;

import com.chickengame.gui.GUI;
import com.chickengame.model.menu.Button;
import com.chickengame.model.levelmenu.ButtonLevel;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.Viewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ButtonViewer extends Viewer<Button> {

    private ImageLoader imageLoader = new ImageLoader();
    private final Map<Button.Type, List<BasicTextImage>> buttonmap;
    public ButtonViewer(Button button) {
        super(button);
        this.buttonmap =new HashMap<>();
        this.buttonmap.put(Button.Type.Play,new ArrayList<BasicTextImage>());
        this.buttonmap.get(Button.Type.Play).add(getImageLoader().getImage("images/menu/play_button.png"));
        this.buttonmap.get(Button.Type.Play).add(getImageLoader().getImage("images/menu/play_button_pressed.png"));
        this.buttonmap.put(Button.Type.Exit,new ArrayList<>());
        this.buttonmap.get(Button.Type.Exit).add(getImageLoader().getImage("images/menu/quit_button.png"));
        this.buttonmap.get(Button.Type.Exit).add(getImageLoader().getImage("images/menu/quit_button_pressed.png"));
        this.buttonmap.put(Button.Type.Shop,new ArrayList<>());
        this.buttonmap.get(Button.Type.Shop).add(getImageLoader().getImage("images/menu/shop_button.png"));
        this.buttonmap.get(Button.Type.Shop).add(getImageLoader().getImage("images/menu/shop_button_pressed.png"));
        this.buttonmap.put(Button.Type.LevelMenu,new ArrayList<>());
        this.buttonmap.get(Button.Type.LevelMenu).add(getImageLoader().getImage("images/menu/Levels_button.png"));
        this.buttonmap.get(Button.Type.LevelMenu).add(getImageLoader().getImage("images/menu/Levels_button_pressed.png"));
        this.buttonmap.put(Button.Type.Help, new ArrayList<>());
        this.buttonmap.get(Button.Type.Help).add(getImageLoader().getImage("images/menu/help_button.png"));
        this.buttonmap.get(Button.Type.Help).add(getImageLoader().getImage("images/menu/help_button_pressed.png"));
    }

    @Override
    public void drawElements(GUI gui) {
        if(getLocation().getType() == Button.Type.Level)
        {
            drawLevelButton(gui);
            return;
        }
        gui.drawImage(getLocation().getPosition(),buttonmap.get(getLocation().getType()).get(getLocation().isSelected()));

    }

    public void drawLevelButton(GUI gui)
    {
        ButtonLevel buttonLevel = (ButtonLevel)getLocation();
        int index = buttonLevel.getLevel()*2- buttonLevel.isSelected()-1;
        gui.drawImage(buttonLevel.getPosition(), buttonmap.get(buttonLevel.getType()).get(index));
    }
}
