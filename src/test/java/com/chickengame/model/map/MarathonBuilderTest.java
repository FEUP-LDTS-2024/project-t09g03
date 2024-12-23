package com.chickengame.model.map;
import com.chickengame.model.game.map.*;
import com.chickengame.model.game.map.MarathonMap;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class MarathonBuilderTest {
/*
    @BeforeEach
    @BeforeProperty
    public void helper()
    {
        map1.getWalls().add(new InvertedElement(10, 20, 24, 47, "candyCane", true));
        map1.getHarmObjects().add(new InvertedElement(90, 100, 70, 15, "cornSpike", false));
        map2.getWalls().add(new Element(50, 60, 40, 42, "platform"));
        map2.getHarmObjects().add(new InvertedElement(110, 120, 70, 15, "toblerone", true));
        map3.getWalls().add(new InvertedElement(130, 140, 26, 46, "cupcake", true));
        map3.getHarmObjects().add(new InvertedElement(170, 180, 23, 15, "gummy", true));

        map1.getElements().add(new InvertedElement(10, 20, 24, 47, "candyCane", true));
        map1.getElements().add(new InvertedElement(90, 100, 70, 15, "cornSpike", false));
        map2.getElements().add(new Element(50, 60, 40, 42, "platform"));
        map2.getElements().add(new InvertedElement(110, 120, 70, 15, "toblerone", true));
        map3.getElements().add(new InvertedElement(130, 140, 26, 46, "cupcake", true));
        map3.getElements().add(new InvertedElement(170, 180, 23, 15, "gummy", true));

    }*/

    @Property
    public void createMarathonMap(@ForAll @IntRange(min = 0, max = 8) int skin)
    {
        MarathonBuilder marathonBuilder = new MarathonBuilder();
        MapBuilder mapBuilder = new MapBuilder();
        MarathonMap marathonMap = marathonBuilder.createMarathonMap(3,"map/", mapBuilder, skin);

        assert marathonMap.getCurrent().getElements().size() == 2;
        assert marathonMap.getNextMap().getElements().size() == 2;
        assert marathonMap.getCurrent().getWalls().size()+ marathonMap.getCurrent().getHarmObjects().size() == marathonMap.getCurrent().getElements().size();
        assert marathonMap.getNextMap().getWalls().size()+ marathonMap.getNextMap().getHarmObjects().size() == marathonMap.getNextMap().getElements().size();
    }



}
