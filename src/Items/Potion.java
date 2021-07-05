package Items;

public class Potion extends Item implements Interfaces.Potion {

    public Potion(String name,int damage, int armor, int hp,int mana) {
        super(name,damage, armor, hp, mana);
    }

    public Potion(String name,int hp,int mana) {
        super(name,hp,mana);
    }
}
