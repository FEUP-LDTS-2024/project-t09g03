package com.chickengame.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;

public class LanternaScreenFactoryTest {
    private TerminalSize terminalSize;
    private DefaultTerminalFactory terminalFactory;
    private List<String> fontpath = new ArrayList<>();
    private Terminal terminal;
    private TerminalScreen terminalScreen;


    @BeforeEach
    public void helper() throws IOException {
        this.terminalSize = Mockito.mock(TerminalSize.class);
        this.terminalFactory = Mockito.mock(DefaultTerminalFactory.class);
        this.fontpath.add("font/square.ttf");
        this.fontpath.add("wrongString");
        this.terminal = Mockito.mock(Terminal.class);
        this.terminalScreen = Mockito.mock(TerminalScreen.class);

        Mockito.when(terminalFactory.createTerminal()).thenReturn(this.terminal);
        Mockito.when(terminalSize.getColumns()).thenReturn(750);
        Mockito.when(terminalSize.getRows()).thenReturn(375);
        Mockito.when(terminal.getTerminalSize()).thenReturn(new TerminalSize(750,375));
        Mockito.when(terminalFactory.createScreen()).thenReturn(this.terminalScreen);
    }

    @Test
    void verifyPath()
    {
        boolean thrown = false;
        try {
            ScreenFactory screenFactoryWrong = new LanternaScreenFactory(terminalFactory, fontpath.get(1), terminalSize);
        }catch (RuntimeException e)
        {
            thrown =  true;
        }
        assertTrue(thrown);
    }

    @Test
    void lanternaScreenTest() throws IOException {

        TerminalScreen screen = (TerminalScreen) new LanternaScreenFactory(terminalFactory,fontpath.getFirst(),terminalSize).createScreen();

        Mockito.verify(terminalFactory, atLeastOnce()).setInitialTerminalSize(terminalSize);
        Mockito.verify(terminalFactory, atLeastOnce()).setForceAWTOverSwing(true);
        Mockito.verify(terminalFactory,atLeastOnce()).setTerminalEmulatorFontConfiguration(any());
        assertEquals(terminalSize.getColumns(), 750);
        assertEquals(terminalSize.getRows(), 375);
        Assertions.assertEquals(screen.getTerminal(),terminal);
    }

    @Test
    void getWidth(){
        LanternaScreenFactory lanternaScreenFactory = new LanternaScreenFactory(terminalFactory,fontpath.getFirst(),terminalSize);
        Assertions.assertEquals(lanternaScreenFactory.getWidth(), terminalSize.getColumns());
        Mockito.verify(terminalSize,atLeastOnce()).getColumns();
    }

    @Test
    void getHeight(){
        LanternaScreenFactory lanternaScreenFactory = new LanternaScreenFactory(terminalFactory,fontpath.getFirst(),terminalSize);
        Assertions.assertEquals(lanternaScreenFactory.getHeight(), terminalSize.getRows());
        Mockito.verify(terminalSize,atLeastOnce()).getRows();
    }
}
