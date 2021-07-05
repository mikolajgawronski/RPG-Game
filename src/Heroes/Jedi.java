package Heroes;

import Combat.Attack;

import java.util.ArrayList;

public class Jedi extends Hero {

    public Jedi(String name, int hp, int mana, int strength, int exp, int armor, int level, ArrayList skillbook, ArrayList Items) {
        super(name, hp, mana, strength, exp, armor, level, skillbook, Items);
    }

    private Attack Force_Push = new Attack("Force Push",0,800);
    private Attack Lightsaber_Throw = new Attack("Lightsaber Throw",0,1000);
    private Attack Basic_Attack = new Attack("Basic Attack",0,getStrength());

    public void addSkills(){
        skillbook.add(Basic_Attack);
        skillbook.add(Force_Push);
        skillbook.add(Lightsaber_Throw);
    }

}
