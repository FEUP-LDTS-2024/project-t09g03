package com.chickengame.state;

import com.chickengame.controller.Controller;
import com.chickengame.controller.game.GameOverController;
import com.chickengame.model.game.GameOver;
import com.chickengame.viewer.GameOverViewer;
import com.chickengame.viewer.Viewer;

public class GameOverState extends State<GameOver>{
    public GameOverState(GameOver location) {
        super(location);
    }

    @Override
    public Viewer<GameOver> getStateViewer() {
        return new GameOverViewer(getLocation());
    }

    @Override
    public Controller<GameOver> getStateController() {
        return new GameOverController(getLocation());
    }
}
