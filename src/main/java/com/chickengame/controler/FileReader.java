package com.chickengame.controler;

import com.chickengame.model.elements.Element;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
/**le Menu.txt e converte cada linha num Element*/
public class FileReader {

    private final Scanner myReader;

    public FileReader(String filePath)
    {
        URL resource = getClass().getClassLoader().getResource("Menus/Lobby.txt");
        try {
            File myFile = new File(resource.toURI());
            this.myReader = new Scanner(myFile);

        } catch (URISyntaxException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Element getNextElement()
    {
        if(myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] args;
            args = line.split(" ");
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            BufferedImage image;
            try {

                image = ImageHandler.getImage(args[2]);
            } catch (URISyntaxException | IOException e) {
                throw new RuntimeException(e);
            }
            return new Element(x, y, image);
        }else
        {
            return null;
        }
    }



}
