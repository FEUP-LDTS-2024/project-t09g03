package com.chickengame.viewer.menu;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.elements.Background;
import com.chickengame.model.game.menu.Button;
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
        this.buttonmap.get(Button.Type.Play).add(imageLoader.getImage("images/menu/play_button.png"));
        this.buttonmap.get(Button.Type.Play).add(imageLoader.getImage("images/menu/play_button_pressed.png"));
        this.buttonmap.put(Button.Type.Exit,new ArrayList<>());
        this.buttonmap.get(Button.Type.Exit).add(imageLoader.getImage("images/menu/quit_button.png"));
        this.buttonmap.get(Button.Type.Exit).add(imageLoader.getImage("images/menu/quit_button_pressed.png"));
        this.buttonmap.put(Button.Type.Shop,new ArrayList<>());
        this.buttonmap.get(Button.Type.Shop).add(imageLoader.getImage("images/menu/shop_button.png"));
        this.buttonmap.get(Button.Type.Shop).add(imageLoader.getImage("images/menu/shop_button_pressed.png"));
    }


    @Override
    protected void drawElements(GUI gui) {

        gui.drawImage(getLocation().getPosition(),buttonmap.get(getLocation().getType()).get(getLocation().isSelected()));

    }
}
