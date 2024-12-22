package com.chickengame.viewer.menus;

import com.chickengame.gui.GUI;
import com.chickengame.model.menus.buttons.Button;
import com.chickengame.viewer.ImageLoader;
import com.chickengame.viewer.ObjectViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class ButtonViewer implements ObjectViewer<Button>
{
    private final BasicTextImage imgButton;
    private final BasicTextImage imgSelectedButton;

    public ButtonViewer(ImageLoader imgLoader, String path, String selectedPath)
    {
        this.imgButton = imgLoader.getImage(path);
        this.imgSelectedButton = imgLoader.getImage(selectedPath);
    }

    public void draw(GUI gui, Button button)
    {
        if(button.isSelected())
        {
            gui.drawImage(button.getPosition(),imgSelectedButton);
        }
        else
        {
            gui.drawImage(button.getPosition(),imgButton);
        }
    }
}
