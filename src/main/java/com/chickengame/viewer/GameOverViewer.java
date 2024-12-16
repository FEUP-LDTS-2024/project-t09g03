package com.chickengame.viewer;

import com.chickengame.gui.GUI;
import com.chickengame.model.Position;
import com.chickengame.model.game.GameOver;
import com.chickengame.viewer.menu.ButtonViewer;
import com.googlecode.lanterna.graphics.BasicTextImage;

public class GameOverViewer extends Viewer<GameOver> {
    private final BasicTextImage background = getImageLoader().getImage("images/menu/gameover/GameOver.png");
    private final ButtonViewer buttonViewer;

    public GameOverViewer(GameOver location) {
        super(location);
        buttonViewer = new ButtonViewer(getLocation().getBack());
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawImage(new Position(0,0), background);
        buttonViewer.drawElements(gui);
    }
}
