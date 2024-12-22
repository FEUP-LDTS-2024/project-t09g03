package com.chickengame.controller

import com.chickengame.Game
import com.chickengame.controller.game.ChickenController
import com.chickengame.controller.game.MapController
import com.chickengame.gui.GUI
import com.chickengame.model.Position
import com.chickengame.model.game.elements.Chicken
import com.chickengame.model.game.map.Map
import com.chickengame.state.GameEndState
import spock.lang.Specification
/*
class MapControllerTestSpock extends Specification{




    def "should handle chicken out scenario"() {
        given:
        def map = Mock(Map)
        def chicken = Mock(Chicken)
        def chickenController = Mock(ChickenController)
        def game = Mock(Game)
        def gui = Mock(GUI)
        def position = new Position(-10, 380)

        chicken.getPosition() >> position
        chickenController.getLocation() >> chicken
        map.collidesHarmObject(_,_,_,_) >> false

        def mapController = new MapController(map, chickenController, 1)

        when:
        mapController.step(game, gui, GUI.Action.INVERT)

        then:
        1 * game.setState(_ as GameEndState)
    }

    def "should handle collision with harmful object"() {
        given:
        def map = Mock(Map)
        def chicken = Mock(Chicken)
        def chickenController = Mock(ChickenController)
        def game = Mock(Game)
        def gui = Mock(GUI)
        def position = new Position(50, 50)

        chicken.getPosition() >> position
        chicken.getWidth() >> 10
        chicken.getHeight() >> 10
        map.collidesHarmObject(50, 60, 50, 60) >> true // Harmful object collision
        chickenController.getLocation() >> chicken

        def mapController = new MapController(map, chickenController, 1)

        when:
        mapController.step(game, gui, GUI.Action.INVERT)

        then:
        1 * game.setState(_ as GameEndState)
    }

    def "should charge chicken on up or down collision"() {
        given:
        def map = Mock(Map)
        def chicken = Mock(Chicken)
        def chickenController = Mock(ChickenController)
        def game = Mock(Game)
        def gui = Mock(GUI)
        def position = new Position(50, 50)

        chicken.getPosition() >> position
        chicken.getWidth() >> 10
        chicken.getHeight() >> 10
        chicken.isInverted() >> false
        map.collidesDown(50, 60, 60) >> true
        map.collidesHarmObject(_,_,_,_)>>false;
        chickenController.getLocation() >> chicken

        def mapController = new MapController(map, chickenController, 1)

        when:
        mapController.step(game, gui, GUI.Action.INVERT)

        then:
        1 * chicken.setCharge(true)
        0 * chickenController.moveY()
    }

    def "should stop chicken movement on right collision"() {
        given:
        def map = Mock(Map)
        def chicken = Mock(Chicken)
        def chickenController = Mock(ChickenController)
        def game = Mock(Game)
        def gui = Mock(GUI)
        def position = new Position(50, 50)

        chicken.getPosition() >> position
        chicken.getWidth() >> 10
        chicken.getHeight() >> 10
        map.collidesRight(60, 50, 60) >> true
        map.collidesHarmObject(_,_,_,_)>>false;
        chickenController.getLocation() >> chicken


        def mapController = new MapController(map, chickenController, 1)

        when:
        mapController.step(game, gui, GUI.Action.INVERT)

        then:
        1 * chickenController.stopX()
    }


}
*/