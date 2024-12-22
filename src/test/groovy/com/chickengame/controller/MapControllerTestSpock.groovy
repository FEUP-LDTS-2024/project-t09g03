package com.chickengame.controller

import com.chickengame.Game
import com.chickengame.controller.game.ChickenController
import com.chickengame.controller.game.MapController
import com.chickengame.gui.GUI
import com.chickengame.model.game.elements.Chicken
import org.mockito.Mockito
import spock.lang.Specification

class MapControllerTestSpock extends Specification{

    def chicken
    def game
    def gui
    def chickenController
    def map


    def setup()
    {
        map = Mock(Map.class)
        chicken = Mock(Chicken.class)
        game = Mock(Game.class)
        gui = Mock(GUI.class)
        chickenController = Mock(ChickenController.class)
    }

    def "testing MapController step"()
    {
        given:
        MapController mapController = new MapController(map,chickenController,5)

        when:
        mapController.step(game,gui, GUI.Action.INVERT)


        then:
        chickenController.getLocation() >> (chicken)


    }


}
