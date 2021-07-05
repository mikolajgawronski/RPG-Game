package Items;

abstract public class Item {
    String name;
    int damage=0,armor=0,hp=0,mana=0;

    public Item(String name, int damage, int armor, int hp, int mana) {
        this.name = name;
        this.damage = damage;
        this.armor = armor;
        this.hp = hp;
        this.mana = mana;
    }

    public Item(String name,int hp, int mana) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
    }

    public Item(String name,int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor += armor;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name=" + name +
                ", damage=" + damage +
                ", armor=" + armor +
                ", hp=" + hp +
                ", mana=" + mana +
                '}';
    }
}
