package Heroes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Combat.Attack;
import Enemies.Bandit;
import Enemies.Enemy;
import Interfaces.Evasive;
import Items.*;
import Log.Log;

abstract public class Hero {
    String name;
    int hp, mana, strength, exp, armor, level,speed;
    int choice=1;
    String choose;
    boolean help=true;
    ArrayList<Attack> skillbook = new ArrayList<>();
    ArrayList<Enemy> Enemies = new ArrayList<Enemy>();
    ArrayList<Item> Items = new ArrayList<>();
    ArrayList<Item> Potions = new ArrayList<>();

    public Hero(String name, int hp, int mana, int strength, int exp, int armor, int level, ArrayList skillbook, ArrayList Items) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.strength = strength;
        this.exp = exp;
        this.armor = armor;
        this.level = level;
        this.skillbook = skillbook;
    }

    abstract public void addSkills();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp += hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana += mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength += strength;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp += exp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor += armor;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level += level;
    }

    public void getEnemies(ArrayList<Enemy> Enemies){
        this.Enemies=Enemies;
    }

    public void selectTarget(){
        System.out.println("Choose your target: ");
        int min=1000;
        for (Enemy Targets: Enemies) {
                System.out.println((Enemies.indexOf(Targets) + 1) + "." + Targets.getName()+" HP:"+Targets.getHp());
        }
        Scanner scan = new Scanner(System.in);
    try {
        choice = scan.nextInt();
        if (choice > Enemies.size() || choice < Enemies.size()) {
        choice = 1;
    }
        }catch (Exception ex){
        choice=1; }

        Choose_Spell(choice);
    }

    private void Choose_Spell(int target){
        Log.info(getName()+"'s current Mana: "+getMana());
        System.out.println("Choose your spell: ");
        for (Attack Spell : skillbook) {
            System.out.println((skillbook.indexOf(Spell)+1)+"."+Spell.getName()+" Mana Cost: "+Spell.getMana_cost()+" Damage: "+Spell.getDamage());
        }
            Scanner scan = new Scanner(System.in);

        try {
                choice = scan.nextInt();
                if (choice > Enemies.size() || choice < Enemies.size()) {
                choice = 1;
                }
            }catch (Exception ex){
            choice=1; }

        if(getMana()>=skillbook.get(choice-1).getMana_cost()) {
            Cast_Spell(skillbook.get(choice - 1), target - 1);
        }
        else{
            Log.info("You don't have enough mana. Required Mana: "+skillbook.get(choice-1).getMana_cost()+" Your Mana: "+getMana());
        }
    }

    private void Cast_Spell(Attack Spell,int target){
        int damage;
        damage=Spell.getDamage() - Enemies.get(target).getArmor();

        System.out.println(getName()+" used "+Spell.getName());
        setMana(-Spell.getMana_cost());

        if(Enemies.get(target) instanceof Evasive){
            Random rand = new Random();
            int r = rand.nextInt(10)+1;
            if(r>=8){
                damage=0;;
            }
        }
        Enemies.get(target).setHp(-damage);

        if(damage>0) {
            Log.info(Enemies.get(target).getName() + " hit for " + damage);
            Enemies.get(target).checkForBonusDamage(Spell,Enemies.get(target));
            Log.info(Enemies.get(target).getName() + "'s HP: " + Enemies.get(target).getHp());
        }

        else if(damage<=0 && Enemies.get(target) instanceof Evasive){
            System.out.println(Enemies.get(target).getName()+" evaded the attack!");
        }

        else if(damage<=0){
            Log.info(Enemies.get(target).getName()+"'s armor is impenetrable for "+getName());
            Log.info("NO DAMAGE DEALT");
        }

        if(Enemies.get(target).getHp() <= 0){
            Log.info(Enemies.get(target).getName()+" is dead");
            setExp(Enemies.get(target).getExp());
            Enemies.remove(target);
        }
    }

    public void getItems() {
        Log.info(getName() + "'s items:" );
        for(Item nazwa:Items){
            System.out.println(nazwa.getName());
        }
    }

    public void checkifLevelUp(){
        while(getExp()>1000){
            Log.info("CONGRATULATIONS "+getName()+" LEVELED UP");
            setExp(-1000);
            setLevel(1);
            Log.info("CURRENT LEVEL: "+getLevel());
            setStrength(5);
            Log.info("CURRENT STRENGTH: "+getStrength());
            setHp(10);
            Log.info("CURRENT HP: "+getHp());
            setMana(5);
            Log.info("CURRENT MANA: "+getMana());
            skillbook.get(0).setDamage(getStrength());
        }
            Log.info("EXP needed for next level up: "+(1000-getExp()));
    }

    public void whatToDo(){
        Log.info("What do you want to do?");
        Scanner scan = new Scanner(System.in);
        Log.info("1. Fight!");
        Log.info("2. Use a Potion!");
        choose = scan.nextLine();
        switch (choose){
            case "1": selectTarget();
            break;
            case "2": selectPotion();
            break;
            default: Log.info("Something went wrong, let's try again");
                whatToDo();
        }
    }

    public void searchForLoot() {
        Random rand = new Random();
        int chance;
        chance = rand.nextInt(20);
        if (chance < 8) {
            Log.info("You haven't found anything from this fight. ");
        }   else if (chance >= 8 && chance < 11) {
                Log.info("You have found healing potion! ");
                Potion potion = new Potion("HP Potion", 0, 0, 50, 0);
                Equip(potion);
        }   else if (chance >= 11 && chance < 14) {
                Log.info("You have found mana potion! ");
                Potion potion = new Potion("Mana Potion", 0, 0, 0, 50);
                Equip(potion);
        }   else if (chance >= 14 && chance < 17) {
                Log.info("You have found new weapon! ");
                Weapon weapon = new Weapon("Toporek", 35, 0, 0, 0);
                checkIfCanEquip(weapon);
        }
            else if (chance >= 17 && chance < 20) {
                Log.info("You have found new armor! ");
                Armor armor = new Armor("Kolczuga", 0, 650, 0, 0);
                checkIfCanEquip(armor);
        }
    }

    public void Equip(Item item){
        help=true;
        checkIfCanEquip(item);
        if(help==true) {
            if (item instanceof Interfaces.Weapon) {
                setStrength(item.getDamage());
                Log.info(getName() + " equipped a " + item.getName()+" Damage: "+item.getDamage());
                Log.info(getName() + "'s Current strength: " + getStrength());
                Items.add(item);
            }
            if (item instanceof Interfaces.Armor) {
                setArmor(item.getArmor());
                Log.info(getName() + " equipped a " + item.getName()+" Armor: "+item.getArmor());
                Log.info(getName() + "'s Current armor: " + getArmor());
                Items.add(item);
            }
            if (item instanceof Interfaces.Potion) {
                Log.info(getName() + " found a " + item.getName());
                Items.add(item);
            }
        }
    }

    public void selectPotion(){
        ArrayList<Item> Potions = new ArrayList<>();
        Log.info("Which potion do you want to use?");
        Log.info("0.Cancel");
        int i=1;
        for (Item itemki : Items) {
            if (itemki instanceof Potion){
                Log.info(i+"."+itemki.getName());
                Potions.add(itemki);
                i++;
            }
        }
        i--;
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();

        if(choice<=i && choice>0){
            choice--;
            setHp(Potions.get(choice).getHp());
            setMana(Potions.get(choice).getMana());
            Log.info(getName()+" used a "+Potions.get(choice).getName());
            Items.remove(Potions.get(choice));
            Potions.remove(choice);
        }
        else if(choice == 0){
            Log.info("No potions were used.");
        }
        if(choice>i){
            selectPotion();
        }
    }

    private void checkIfCanEquip(Item item) {
        if (item instanceof Interfaces.Weapon) {
            for (int i = 0; i < Items.size(); i++) {
                if (Items.get(i) instanceof Interfaces.Weapon) {
                    Log.info(getName() + " already has a weapon: " + Items.get(i).getName() + " Strength: " + Items.get(i).getDamage());
                    Log.info(getName() + " found a new weapon: " + item.getName() + " Strength: " + item.getDamage());
                    if (Items.get(i).getDamage() > item.getDamage()) {
                        Log.info("Currently equipped weapon is better than " + item.getName());
                        help = false;
                    } else if (Items.get(i).getDamage() < item.getDamage()) {
                        Log.info("New weapon is better than current weapon");
                        setStrength(-Items.get(i).getDamage());
                        Items.remove(Items.get(i));
                        help = true;
                    }
                }
            }
        }
            if (item instanceof Interfaces.Armor) {
                for (int i=0;i<Items.size();i++) {
                    if (Items.get(i) instanceof Interfaces.Armor) {
                        Log.info(getName() + " already has a armor: " + Items.get(i).getName() + " Armor: " + Items.get(i).getArmor());
                        Log.info(getName() + " found a new armor: " + item.getName() + " Armor: " + item.getArmor());
                        if (Items.get(i).getArmor() > item.getArmor()) {
                            Log.info("Currently equipped armor is better than " + item.getName());
                            help=false;
                        }
                        else if (Items.get(i).getArmor() < item.getArmor()) {
                            Log.info("New armor is better than current armor");
                            setArmor(-Items.get(i).getArmor());
                            Items.remove(Items.get(i));
                            help=true;
                        }
                    }
                }
            }
        }
}