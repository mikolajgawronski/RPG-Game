package Enemies;

import Interfaces.Dragon;

public class RedDragon extends Enemy implements Dragon {

    public RedDragon(String name, int hp, int strength, int exp, int armor) {
        super(name, hp, strength, exp, armor);
    }

}
