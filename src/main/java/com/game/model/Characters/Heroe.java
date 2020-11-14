package com.game.model.Characters;

import com.game.model.GameBoard;
import com.game.model.Handles.HandlerGameObjects;
import com.game.model.ID;
import com.game.model.Team;

public class Heroe extends ContactWarrior {
    
    public Heroe(int x, int y, String imgPath, Team team, GameBoard gameBoard, HandlerGameObjects handlerGameObjects) {
        super(x, y, ID.HEROE, imgPath, team, gameBoard, handlerGameObjects);
    }
    
    @Override
    public void upgrade(){
        // El no crece
    }
}
