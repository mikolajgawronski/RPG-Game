package Enemies;

import Interfaces.Evasive;

public class Bandit extends Enemy implements Interfaces.FighterAI, Evasive {
    public Bandit(String name, int hp, int strength, int exp, int armor) {
        super(name, hp, strength, exp, armor);
    }
}
