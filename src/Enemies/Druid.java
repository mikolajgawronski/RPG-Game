package Enemies;

import Combat.Attack;

import java.util.ArrayList;

public class Druid extends Enemy implements Interfaces.Elves {

    ArrayList<Attack> Druid_Spells = new ArrayList<>();

    private Attack Natures_Wrath = new Attack("Nature's Wrath",0,20);
    private Attack Ice_wave = new Attack("Ice Wave",0,30);


    public Druid(String name, int hp, int strength, int exp, int armor) {
        super(name, hp, strength, exp, armor);
        addSkills();
    }

    private void addSkills(){
        Druid_Spells.add(Natures_Wrath);
        Druid_Spells.add(Ice_wave);
    }



}
