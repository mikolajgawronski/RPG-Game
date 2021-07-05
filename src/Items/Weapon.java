package Items;

public class Weapon extends Item implements Interfaces.Weapon {
    public Weapon(String name,int damage, int armor, int hp,int mana) {
        super(name,damage, armor, hp,mana);
    }

    public Weapon(String name,int damage) {
        super(name,damage);
    }


}
