package Heroes;

import Combat.Attack;
import Interfaces.Evasive;

import java.util.ArrayList;

public class Thief extends Hero implements Evasive {


    public Thief(String name, int hp, int mana, int strength, int exp, int armor, int level, ArrayList skillbook,ArrayList Item) {
        super(name, hp, mana, strength, exp, armor, level, skillbook,Item);
    }

    private Attack Stab = new Attack("Stab",0,15);
    private Attack Piercing_Strike = new Attack("Piercing Strike",10,25);
    private Attack Blow_Of_Anguish = new Attack("Blow Of Anguish",30,60);
    private Attack Basic_Attack = new Attack("Basic Attack",0,getStrength());


    public void addSkills() {
        skillbook.add(Basic_Attack);
        skillbook.add(Stab);
        skillbook.add(Piercing_Strike);
        skillbook.add(Blow_Of_Anguish);
    }
}
