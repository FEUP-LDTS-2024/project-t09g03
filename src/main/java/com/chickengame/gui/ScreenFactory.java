package com.chickengame.gui;

import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface ScreenFactory {
    Screen createScreen() throws IOException;
    int getWidth();
    int getHeight();
}
