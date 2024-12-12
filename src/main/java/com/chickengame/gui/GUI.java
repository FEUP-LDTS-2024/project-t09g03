package com.chickengame.gui;

import com.chickengame.model.Position;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI {
    public Screen getScreen();
    public void drawImage(Position position, BasicTextImage basicTextImage);
    public KeyStroke getKey() throws IOException;
    public int processKey() throws IOException;
    public void clear();
    public void refresh() throws IOException;
    public void close() throws IOException;
}
