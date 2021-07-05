package Heroes;

import Combat.Attack;

import java.util.ArrayList;

public class Priest extends Hero {
    public Priest(String name, int hp, int mana, int strength, int exp, int armor, int level, ArrayList skillbook,ArrayList Item) {
        super(name, hp, mana, strength, exp, armor, level, skillbook,Item);
    }


    private Attack Holy_Fire = new Attack("Holy Fire",10,25);
    private Attack Holy_Rage = new Attack("Holy Rage",15,35);
    private Attack Basic_Attack = new Attack("Basic Attack",0,getStrength());

    public void addSkills(){
        skillbook.add(Basic_Attack);
        skillbook.add(Holy_Fire);
        skillbook.add(Holy_Rage);
    }
}
