package Enemies;

import Interfaces.Undead;

import java.util.ArrayList;

public class Zombie extends Enemy implements Undead {

    public Zombie(String name, int hp, int strength, int exp, int armor) {
        super(name, hp, strength, exp, armor);
    }
}
