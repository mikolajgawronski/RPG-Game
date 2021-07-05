package Items;



public class Armor extends Item implements Interfaces.Armor {

    public Armor(String name,int damage, int armor, int hp,int mana) {
        super(name,damage, armor, hp,mana);
    }

    public Armor(String name,int armor) {
        super(name,armor);
    }
}
