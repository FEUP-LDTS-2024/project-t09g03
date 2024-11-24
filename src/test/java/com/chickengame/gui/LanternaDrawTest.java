package com.chickengame.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanternaDrawTest
{
    private Screen screen;
    private TextGraphics textGraphics;
    private LanternaDraw lanterna;

    @BeforeEach
    void helper()
    {
        this.screen = Mockito.mock(Screen.class);
        this.textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(this.screen.newTextGraphics()).thenReturn(textGraphics);

        lanterna = new LanternaDraw(this.screen);
    }

    @Test
    void draw()
    {
        this.lanterna.draw(0,0,"#FFFFFF");
        Mockito.verify(this.textGraphics,Mockito.times(1)).setCharacter(0,0,' ');
        Mockito.verify(this.textGraphics,Mockito.times(1)).setBackgroundColor(new TextColor.RGB(255, 255, 255));

    }
}
