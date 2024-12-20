package com.chickengame.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.chickengame.model.Position;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI
{
    enum Action {UP, DOWN, SELECT, INVERT, QUIT, NONE, LEFT, RIGHT, CLICK}
    public Screen getScreen();
    public GUI.Action getNextAction() throws IOException;
    public void drawImage(Position position, BasicTextImage basicTextImage);
    public void refresh() throws IOException;
    public void close() throws IOException;
}
