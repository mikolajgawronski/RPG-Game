import Combat.Combat;
import Enemies.Enemy;
import Enemies.Goblin;
import Heroes.Hero;
import Heroes.PartyCustomization;
import Heroes.Warrior;
import Heroes.Mage;
import Enemies.*;
import Items.Armor;
import Items.Item;
import Items.Potion;
import Items.Weapon;
import Log.Log;

import java.util.ArrayList;
import java.util.Random;

public class main {

    public static void deleteMonsters(ArrayList Enemies){
        for (int i = Enemies.size(); i > 0; i--) {
            Enemies.remove(i);
        }
    }

    public static void addMonsters(int room, ArrayList Enemies){
        int randomMonster=0;
        Random rand = new Random();
        switch(room){

            case 1:
                    for(int a=0;a<2;a++) {
                        randomMonster = rand.nextInt(4);
                        switch (randomMonster) {
                            case 0:
                                Enemies.add(new Goblin("Goblin", 25, 10, 250, 0));
                                break;
                            case 1:
                                Enemies.add(new Zombie("Zombie", 35, 15, 300, 5));
                                break;
                            case 2:
                                Enemies.add(new Bandit("Bandit", 40, 25, 400, 15));
                                break;
                            case 3:
                                Enemies.add(new ForestSpirit("Forest Spirit", 25, 15, 300, 0));
                                break;
                        }
                    }break;

            case 2:
                for(int a=0;a<2;a++) {
                    randomMonster = rand.nextInt(4);
                    switch (randomMonster) {
                        case 0:
                            Enemies.add(new Minotaur("Minotaur", 55, 25, 400, 20));
                            break;
                        case 1:
                            Enemies.add(new Dendroid("Dendroid", 70, 20, 500, 45));
                            break;
                        case 2:
                            Enemies.add(new Vampire("Vampire", 40, 30, 600, 15));
                            break;
                        case 3:
                            Enemies.add(new Druid("Druid", 25, 20, 600, 15));
                            break;
                    }
                }break;

            case 3:
                randomMonster = rand.nextInt(3);
                switch (randomMonster) {
                    case 0:
                        Enemies.add(new BlackDragon("Black Dragon", 100, 40, 2000, 40));
                        break;
                    case 1:
                        Enemies.add(new Hydra("Hydra", 100, 30, 2000, 35));
                        break;
                    case 2:
                        Enemies.add(new RedDragon("Red Dragon", 100, 30, 2000, 30));
                        break;
                }
        }
    }
    public static void main(String[] args) {

        ArrayList<Hero> Party = new ArrayList<>();
        ArrayList<Enemy> Enemies = new ArrayList<>();

        Combat combat = new Combat();
        PartyCustomization selectHero = new PartyCustomization();


        Party.add(selectHero.selectHero());
        Hero yourHero = Party.get(0);
        Log.info(yourHero.getName()+" joined the game.");

        for (int room = 1; room < 4 ; room++) {
            addMonsters(room,Enemies);
            combat.Fight(Party,Enemies);
            yourHero.getItems();
            deleteMonsters(Enemies);
            Log.info("YOU'VE WON BATTLE NUMBER: "+room);
        }
            Log.info("YOU WON THE GAME! CONGRATS!");
    }
}
