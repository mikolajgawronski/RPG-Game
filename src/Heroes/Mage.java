package Heroes;

import java.util.ArrayList;
import Combat.Attack;
import Items.Item;

public class Mage extends Hero {
    private Attack Fireball = new Attack("Fireball",5,20);
    private Attack Icebolt = new Attack("Icebolt",10,45);
    private Attack Lightning_Bolt = new Attack("Lightning Bolt",15,70);
    private Attack Basic_Attack = new Attack("Basic Attack",0,getStrength());

    public Mage(String name, int hp, int mana, int strength, int exp, int armor, int level, ArrayList skillbook, ArrayList Items) {
        super(name, hp, mana, strength, exp, armor, level, skillbook, Items);
    }


    public void addSkills(){
        skillbook.add(Basic_Attack);
        skillbook.add(Fireball);
        skillbook.add(Icebolt);
        skillbook.add(Lightning_Bolt);
    }


}
