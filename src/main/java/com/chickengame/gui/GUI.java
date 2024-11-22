package com.chickengame.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI {
    public Screen getScreen();
    public TextGraphics getGraphics();
    public KeyStroke getKey() throws IOException;
}
