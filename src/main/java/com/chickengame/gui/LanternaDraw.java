package com.chickengame.gui;

import com.chickengame.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;


public class LanternaDraw implements GUI
{
    private Screen screen;
    private final TextGraphics textGraphics;
    public static final int WIDTH = 750;
    public static final int HEIGHT = 375;


    public LanternaDraw(Screen screen) throws IOException
    {
        this.screen = screen;
        this.screen.startScreen();
        this.textGraphics = screen.newTextGraphics();
    }

    @Override
    public Screen getScreen()
    {
        return screen;
    }

    @Override
    public void drawImage(Position position, BasicTextImage basicTextImage)
    {
        TerminalPosition pos = new TerminalPosition(position.getX(),position.getY());
        textGraphics.drawImage(pos,basicTextImage);
    }

    @Override
    public Action getNextAction() throws IOException
    {
        KeyStroke key = screen.pollInput();
        if(key != null)
        {
            return switch(key.getKeyType())
            {
                case EOF -> Action.QUIT;
                case Enter -> Action.SELECT;
                case Escape -> Action.QUIT;
                case ArrowRight -> Action.RIGHT;
                case ArrowLeft -> Action.LEFT;
                case ArrowUp -> Action.UP;
                case ArrowDown -> Action.DOWN;
                case KeyType.Character->
                        switch (key.getCharacter())
                        {
                            case ' '->Action.INVERT;
                            case 'q'->Action.QUIT;
                            default -> Action.NONE;
                        };
                default -> Action.NONE;
            };
        }
        return Action.NONE;
    }

    @Override
    public void refresh() throws  IOException
    {
        this.screen.refresh();
    }

    @Override
    public void close() throws IOException
    {
        this.screen.close();
    }

}
