package Heroes;

import java.util.ArrayList;
import Combat.Attack;

public class Warrior extends Hero {
    public Warrior(String name, int hp, int mana, int strength, int exp, int armor, int level, ArrayList skillbook, ArrayList Items) {
        super(name, hp, mana, strength, exp, armor, level, skillbook, Items);
    }

    private Attack Slash = new Attack("Slash",0,30);
    private Attack Charge = new Attack("Charge",10,50);
    private Attack Cleave = new Attack("Cleave",20,70);
    private Attack Basic_Attack = new Attack("Basic Attack",0,getStrength());

    public void addSkills(){
        skillbook.add(Basic_Attack);
        skillbook.add(Slash);
        skillbook.add(Charge);
        skillbook.add(Cleave);
    }

}