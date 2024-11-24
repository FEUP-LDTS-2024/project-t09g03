package com.chickengame.model.menu;

import com.chickengame.controler.FileReader;
import com.chickengame.model.elements.Element;

import java.util.ArrayList;

/**extrai informacao dada e guarda a para ser utilizada no LobbbyState*/
public class Lobby extends Menu{

    private final FileReader myReader;

    public Lobby(String lobbyFile)
    {
        this.myReader = new FileReader(lobbyFile);
        super.elements = new ArrayList<>();
        fillElements();
    }
    private void fillElements()
    {
        while(true)
        {
            Element element = myReader.getNextElement();
            if(element==null)break;
            super.elements.add(element);
        }
    }


}
