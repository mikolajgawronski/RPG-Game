package Combat;

public class Attack {

    String name;
    int mana_cost;
    int damage;

    public Attack(String name, int mana_cost, int damage) {
        this.name = name;
        this.mana_cost = mana_cost;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getMana_cost() {
        return mana_cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) { this.damage = damage; }

}