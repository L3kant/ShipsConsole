package cz.l3kant.shipsconsole.components.entities;

import cz.l3kant.shipsconsole.commons.GameField;
import cz.l3kant.shipsconsole.commons.ships.Ship;

/**
 * @author l3kant
 */
public abstract class Entity {
    GameField field = new GameField(10,10);
    Ship [] boats = new Ship [3];
    Ship [] destroyers = new Ship [2];
    Ship [] cruisers = new Ship [2];
    Ship [] battleships = new Ship [1];
    
    public abstract void start();
    
}
