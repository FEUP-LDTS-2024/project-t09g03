package com.chickengame.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
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

    private Screen screen;
//Private Members

    public LanternaDraw() {
        URL resource = getClass().getClassLoader().getResource("Font/square.ttf");
        File fontFile = null;
        try {
            fontFile = new File(resource.toURI());
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            Terminal terminal = null;
            terminal = createTerminal(1000,500, font);
            createScreen(terminal);
        } catch (FontFormatException | IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

        private Terminal createTerminal(int width, int height, Font font) throws IOException {
        // Process font to AWTTerminalFontConfiguration
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 2);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);

        //create Terminal
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private void createScreen(Terminal terminal) throws IOException {
    this.screen = new TerminalScreen(terminal);
    this.screen.setCursorPosition(null);
    this.screen.startScreen();
    this.screen.doResizeIfNecessary();
    }

    @Override
    public Screen getScreen() {
        return screen;
    }

    @Override
    public TextGraphics getGraphics() {
        return screen.newTextGraphics();
    }

    @Override
    public KeyStroke getKey() throws IOException {
        return screen.pollInput();
    }
}
