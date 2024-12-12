package com.chickengame.gui;

import com.chickengame.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaDraw implements GUI{

    private KeyStroke lastkeystroke;
    private Screen screen;
    private final TextGraphics textGraphics;

    public LanternaDraw() {
        URL resource = getClass().getClassLoader().getResource("font/square.ttf");
        try {
            File fontFile = new File(resource.toURI());
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            Terminal terminal = createTerminal(750,375, font);
            createScreen(terminal);
            this.textGraphics = this.screen.newTextGraphics();
        } catch (FontFormatException | IOException | URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
    }

    private Terminal createTerminal(int width, int height, Font font) throws IOException
    {
        // Process font to AWTTerminalFontConfiguration
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 2);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);

        //create Terminal
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }

    private void createScreen(Terminal terminal) throws IOException
    {
        this.screen = new TerminalScreen(terminal);
        this.screen.setCursorPosition(null);
        this.screen.startScreen();
        this.screen.doResizeIfNecessary();
    }

    @Override
    public Screen getScreen()
    {
        return screen;
    }

    @Override
    public void drawImage(Position position, BasicTextImage basicTextImage) {
        TerminalPosition pos = new TerminalPosition(position.getX(),position.getY());
        textGraphics.drawImage(pos,basicTextImage);

    }

    @Override
    public Action getNextAction() throws IOException
    {
        KeyStroke key = screen.pollInput();
        if(key == null)
        {
            return Action.NONE;
        }
        return switch(key.getKeyType())
        {
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

    @Override
    public int processKey() throws IOException {
        KeyStroke key = screen.pollInput();
        if(key != null)
        {
            if(key.getCharacter() == 'q')
            {
                this.close();
                return 1;
            }

        }
        return 0;
    }
}
