package com.chickengame.viewer;

import com.chickengame.controler.ImageHandler;
import com.chickengame.model.menu.Menu;
import com.chickengame.model.elements.Element;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;
/**classe para desenhar o menu na tela*/
public class MenuViewer
{
    private final TextGraphics graphics;
    private final List<Element> elements;
    private final ImageHandler imageHandler;
    private ObjectPainter painter;
    /**graphics: ferramenta do lanterna para desenhar o menu
     * elements: os elementos que pertencem a um certo menu
     * imageHandler: interpretador da imagem dada
     * painter: desenhar na tela*/
    public MenuViewer(TextGraphics graphics, Menu menu)
    {
        this.graphics = graphics;
        this.elements = menu.getElements();
        this.imageHandler = new ImageHandler();
        this.painter = new ObjectPainter();
    }
    /**desenha cada elemento do menu na tela*/
    public void drawMenu()
    {
        for(Element e : elements)
        {
            painter.draw(graphics,imageHandler, e);
        }
    }

}
