package com.chickengame.controller

import com.chickengame.Game
import com.chickengame.controller.game.ChickenController
import com.chickengame.gui.GUI
import com.chickengame.model.game.elements.Chicken
import spock.lang.Specification;

class ChickenControllerTestSpock extends Specification{

    def chicken
    def game
    def gui
    def action
    def chickenController
    def setup()
    {
        chicken = Mock(Chicken.class)
        game = Mock(Game.class);
        gui = Mock(GUI.class);
        action = GUI.Action.INVERT
    }



    def "testing the invert "()
    {
        given:

            chickenController = new ChickenController(chicken)
        when:

            chickenController.step(game,gui, action)

        then:
            1 * chicken.isCharge()>>true
            1 * chicken.isInverted()>>true
            1 * chicken.setInverted(false)
            1 * chicken.setCharge(false)
    }



}
