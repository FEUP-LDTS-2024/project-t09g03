package com.chickengame.gui;
import com.chickengame.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import net.jqwik.api.*;
import net.jqwik.api.constraints.CharRange;
import net.jqwik.api.constraints.WithNull;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static com.chickengame.gui.GUI.Action.NONE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LanternaDrawTest {
    private Screen screen;
    private TextGraphics textGraphics;
    private LanternaDraw lanterna;
    private Map<KeyStroke, GUI.Action> keyTypeActionMap = new HashMap<>();
    private static final int WIDTH = 750;
    private static final int HEIGHT = 375;

    @BeforeEach
    void helper() throws IOException {
        this.screen = Mockito.mock(Screen.class);
        this.textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(this.screen.newTextGraphics()).thenReturn(textGraphics);
        lanterna = new LanternaDraw(screen);
    }

    @Test
    void drawImage() {
        Position position = new Position(0, 0);
        BasicTextImage image = Mockito.mock(BasicTextImage.class);

        lanterna.drawImage(position, image);

        TerminalPosition terminalPosition = new TerminalPosition(position.getX(), position.getY());
        Mockito.verify(textGraphics, times(1)).drawImage(terminalPosition, image);
    }

    @BeforeProperty
    void helperProperty() throws IOException {
        this.screen = Mockito.mock(Screen.class);
        lanterna = new LanternaDraw(screen);
        keyTypeActionMap.put(new KeyStroke(KeyType.EOF), GUI.Action.QUIT);
        keyTypeActionMap.put(new KeyStroke(KeyType.ArrowUp), GUI.Action.UP);
        keyTypeActionMap.put(new KeyStroke(KeyType.ArrowLeft), GUI.Action.LEFT);
        keyTypeActionMap.put(new KeyStroke(KeyType.ArrowRight), GUI.Action.RIGHT);
        keyTypeActionMap.put(new KeyStroke(KeyType.ArrowDown), GUI.Action.DOWN);
        keyTypeActionMap.put(new KeyStroke(KeyType.Escape), GUI.Action.QUIT);
        keyTypeActionMap.put(new KeyStroke(KeyType.Enter), GUI.Action.SELECT);
        keyTypeActionMap.put(new KeyStroke(' ', false, false), GUI.Action.INVERT);
        keyTypeActionMap.put(new KeyStroke('q', false, false), GUI.Action.QUIT);
    }

    @Property
    void getNextAction(@WithNull @ForAll("keyTypeArbitrary") KeyType key) throws IOException {
        KeyStroke realkey = null;
        if (key != null) {
            realkey = new KeyStroke(key);
        }
        Mockito.when(screen.pollInput()).thenReturn(realkey);
        GUI.Action action = lanterna.getNextAction();
        assertEquals(keyTypeActionMap.getOrDefault(realkey, NONE), action);
    }

    @Provide
    Arbitrary<KeyType> keyTypeArbitrary() {
        return Arbitraries.of(KeyType.F1, KeyType.EOF, KeyType.Enter, KeyType.Escape, KeyType.ArrowUp, KeyType.ArrowDown, KeyType.ArrowLeft, KeyType.ArrowRight);
    }

    @Property
    void charGetNextAction(@ForAll @CharRange(from = 0, to = 255) char c) throws IOException {
        KeyStroke realStroke = new KeyStroke(c, false, false);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(c, false, false));
        GUI.Action action = lanterna.getNextAction();
        assertEquals(keyTypeActionMap.getOrDefault(realStroke, NONE), action);
    }

    @Test
    void getScreenTest() throws IOException {
        LanternaDraw lanternaDraw = new LanternaDraw(screen);
        Assertions.assertEquals(screen,lanternaDraw.getScreen());
    }
    @Test
    void lanternaDraw() throws IOException {
        Mockito.verify(this.screen).startScreen();
        assertNotNull(this.lanterna);
        assertEquals(WIDTH, LanternaDraw.WIDTH);
        assertEquals(HEIGHT, LanternaDraw.HEIGHT);
        Mockito.verify(this.screen).newTextGraphics();
    }

    @Test
    void refresh() throws IOException {
        lanterna.refresh();
        Mockito.verify(screen, atLeastOnce()).refresh();
    }

    @Test
    void close() throws IOException {
        lanterna.close();
        Mockito.verify(screen, times(1)).close();
    }
}