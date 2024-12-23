package com.chickengame.model.game.map;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;

public class MarathonBuilderTest {

    @Property
    public void createMarathonMap(@ForAll @IntRange(min = 0, max = 8) int skin)
    {
        MarathonBuilder marathonBuilder = new MarathonBuilder();
        MapBuilder mapBuilder = new MapBuilder();
        MarathonMap marathonMap = marathonBuilder.createMarathonMap(3,"map/", mapBuilder, skin);

        Assertions.assertEquals(marathonMap.getCurrent().getElements().size(), 2);
        Assertions.assertEquals(marathonMap.getNextMap().getElements().size(), 2);
        Assertions.assertEquals(marathonMap.getCurrent().getWalls().size()+ marathonMap.getCurrent().getHarmObjects().size() , marathonMap.getCurrent().getElements().size());
        Assertions.assertEquals(marathonMap.getNextMap().getWalls().size()+ marathonMap.getNextMap().getHarmObjects().size() , marathonMap.getNextMap().getElements().size());
    }







}
