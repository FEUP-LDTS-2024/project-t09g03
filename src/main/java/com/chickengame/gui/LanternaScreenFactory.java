package com.chickengame.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
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

public class LanternaScreenFactory implements ScreenFactory {

    private TerminalSize terminalSize;
    private DefaultTerminalFactory terminalFactory;


    public LanternaScreenFactory(DefaultTerminalFactory terminalFactory, TerminalSize terminalSize)
    {
        this.terminalSize = terminalSize;
        this.terminalFactory = terminalFactory;

        Font font = getFont("font/square.ttf");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 2);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);

        //create Terminal
        this.terminalFactory.setInitialTerminalSize(terminalSize);
        this.terminalFactory.setForceAWTOverSwing(true);
        this.terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
    }

    private Font getFont(String fontPath)
    {
        URL resource = getClass().getClassLoader().getResource(fontPath);
        Font font = null;
        try {
            File fontFile = new File(resource.toURI());
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        } catch (FontFormatException | IOException | URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
        return font;
    }


    @Override
    public Screen createScreen() throws IOException {
        Terminal terminal = null;
        Screen screen = null;

            terminal = this.terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.doResizeIfNecessary();
        return screen ;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
