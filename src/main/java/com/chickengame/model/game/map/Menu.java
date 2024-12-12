package com.chickengame.model.game.map;

import com.chickengame.model.game.elements.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<Element> elements;
    private int currentElement = 0;

    public Menu() {
        this.elements = new ArrayList<>();
    }

    public void nextEntry() {
        currentElement++;
        if (currentElement > this.elements.size() - 1)
            currentElement = 0;
    }

    public void previousEntry() {
        currentElement--;
        if (currentElement < 0)
            currentElement = this.elements.size() - 1;
    }

    public Element getEntry(int i) {
        return elements.get(i);
    }

    public boolean isSelected(int i) {
        return currentElement == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.elements.size();
    }
}
