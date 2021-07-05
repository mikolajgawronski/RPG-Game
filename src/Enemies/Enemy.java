package Enemies;

import Combat.Attack;
import Heroes.Hero;
import Heroes.Warrior;
import Interfaces.*;
import Log.*;
import Items.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

abstract public class Enemy {
    String name;
    int hp, strength, exp, armor;


    public Enemy(String name, int hp, int strength, int exp, int armor) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.exp = exp;
        this.armor = armor;
    }

    ArrayList<Hero> Party = new ArrayList<>();

    public void setHeroes(ArrayList<Hero> Party) {
        this.Party = Party;
    }

    public void Attack() {

        int damage;
        damage = strength-Party.get(0).getArmor();

        if(Party.get(0) instanceof Evasive){
            Random rand = new Random();
            int r = rand.nextInt(10)+1;
            if(r>=8){
                damage=0;;
            }
        }

        if(damage>0) {
            Party.get(0).setHp(-damage);
            Log.info(getName() + " attacks " + Party.get(0).getName() + " for " + damage);
            Log.info(Party.get(0).getName() + "'s HP: " + Party.get(0).getHp());
            useAbility(damage);
        }

        else if(damage<=0 && Party.get(0) instanceof Evasive){
            System.out.println(Party.get(0).getName()+" evaded the attack!");
        }

        else if(damage<=0){
            Log.info(Party.get(0).getName()+"'s armor is impenetrable for "+getName());
            Log.info("NO DAMAGE DEALT");
        }

        if (Party.get(0).getHp() <= 0){
            Log.info(Party.get(0).getName() + " is Dead");
            Log.info("YOUR HERO IS DEAD. GAME OVER.");
            System.exit(0);
        }
    }


    public void useAbility(int damage){

        if(this instanceof Creature){
            System.out.println(this.getName()+" is on a Rampage and attacks once more!");
            Random rand = new Random();
            int r = rand.nextInt(10)+1;
            if(r>=7){
                this.Attack();
            }
        }

        if(this instanceof Zombie){
            Random rand = new Random();
            int r = rand.nextInt(10)+1;
            Party.get(0).setHp(-r);
            Log.info(Party.get(0).getName()+"'s HP: "+Party.get(0).getHp());
        }

        if(this instanceof ForestSpirit){
            Party.get(0).setMana(-5);
            Log.info(getName()+" has stolen 5 MANA from "+Party.get(0).getName());
            Log.info(Party.get(0).getName()+"'s MANA: "+Party.get(0).getMana());
        }

        if(this instanceof Vampire){
            this.setHp(damage/2);
            Log.info(this.getName()+" healed itself for "+(damage/2));
            Log.info(this.getName()+"'s HP: "+this.getHp());
        }

        if(this instanceof Druid){
            Random rand = new Random();
            int r = rand.nextInt(2);
            System.out.println(getName()+" used "+((Druid) this).Druid_Spells.get(r).getName()+" and dealt additional "+((Druid) this).Druid_Spells.get(r).getDamage());
            Party.get(0).setHp(((Druid) this).Druid_Spells.get(r).getDamage());
            Log.info(Party.get(0).getName()+"'s HP: "+Party.get(0).getHp());
        }

        if(this instanceof Dendroid) {
            this.setArmor(1);
        }


        if(this instanceof Dragon){
            Random rand = new Random();
            int r = rand.nextInt(5);

            if(r<=1){
                System.out.println("Dragon's fire burns "+Party.get(0).getName()+" for additional 10 damage!");
                Party.get(0).setHp(-10);
                Log.info(Party.get(0).getName()+"'s HP: "+Party.get(0).getHp());
            }
            else if(r<=3){
                System.out.println("Dragon's fire burns "+Party.get(0).getName()+" for additional 20 damage!");
                Party.get(0).setHp(-20);
                Log.info(Party.get(0).getName()+"'s HP: "+Party.get(0).getHp());
            }
            else if(r==4){
                System.out.println("Dragon's fire burns "+Party.get(0).getName()+" for additional 30 damage!");
                Party.get(0).setHp(-30);
                Log.info(Party.get(0).getName()+"'s HP: "+Party.get(0).getHp());
            }
        }


    }




    public void checkForBonusDamage(Attack Spell,Enemy enemy) {

        if(enemy instanceof Undead){
            if(Spell.getName().equals("Holy Fire")){
                enemy.setHp(-10);
                Log.info(getName()+" hit for additional 10 damage due to it's weakness to "+Spell.getName());
            }
            if(Spell.getName().equals("Holy Rage")){
                enemy.setHp(-15);
                Log.info(getName()+" hit for additional 15 damage due to it's weakness to "+Spell.getName());
            }
        }

        if(enemy instanceof Creature || enemy instanceof FighterAI){
            if(Party.get(0) instanceof Warrior){
                enemy.setHp(-10);
                Log.info(getName()+" hit for additional 10 damage due to warrior's hatred for its kind! ");
            }
        }

        if(enemy instanceof Dendroid && Spell.getName().equals("Fireball")) {
            enemy.setHp(-50);
        }

        if(enemy instanceof Hydra){
            setStrength(10);
        }

    }

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
        this.exp = exp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor += armor;
    }

}