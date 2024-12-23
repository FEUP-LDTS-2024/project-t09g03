package com.chickengame.model.game.map;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class MarathonBuilderTest {

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
