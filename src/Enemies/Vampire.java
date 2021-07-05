package Enemies;

public class Vampire extends Enemy implements Interfaces.Undead {
    public Vampire(String name, int hp, int strength, int exp, int armor) {
        super(name, hp, strength, exp, armor);
    }
}
