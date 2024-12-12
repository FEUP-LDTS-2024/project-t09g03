package com.chickengame.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI {
    enum Action {UP, DOWN, SELECT, INVERT, QUIT, NONE, LEFT, RIGHT, CLICK}
    public Screen getScreen();
    public void draw(int x, int y, String paint);
    public GUI.Action getNextAction() throws IOException;
    public int processKey() throws IOException;
    public void close() throws IOException;
}
