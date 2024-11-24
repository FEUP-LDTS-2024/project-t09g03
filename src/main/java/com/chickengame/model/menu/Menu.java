package com.chickengame.model.menu;

import com.chickengame.model.game.elements.Element;

import java.util.List;
/**lista de elementos contida em cada menu*/
public abstract class Menu {
    protected List<Element> elements;

    public List<Element> getElements()
    {
        return elements;
    }


}
