package Heroes;

import Items.Armor;
import Items.Weapon;
import Log.Log;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PartyCustomization {

    public Hero selectHero(){
        showHeroes();
        Log.info("Wybierz bohatera : ");
        Scanner scan = new Scanner(System.in);
        String w = scan.nextLine();


        switch (w){
            case "1":
                Mage mage = new Mage("Xardas",80,120,10,0,5,1,new ArrayList(),new ArrayList());
                mage.addSkills();
                return mage;
            case "2":
                Priest priest = new Priest("Priest",110,90,15,0,5,1,new ArrayList(),new ArrayList());
                priest.addSkills();
                return priest;
            case "3":
                Thief thief = new Thief("Thief",100,70,20,0,10,1,new ArrayList(),new ArrayList());
                thief.addSkills();
                return thief;
            case "4":
                Warrior warrior = new Warrior("Warrior",130,50,25,0,15,1,new ArrayList(),new ArrayList());
                warrior.addSkills();
                return warrior;
            case "ź":
            case "Ź":
                Jedi Obi_Wan = new Jedi("Obi-Wan Kenobi",1000,1000,500,0,500,30,new ArrayList(),new ArrayList());
                Obi_Wan.addSkills();
                Log.info("YOU'VE FOUND AN EASTER EGG!");
                Weapon Lightsaber = new Weapon("Lightsaber",1000);
                Obi_Wan.Equip(Lightsaber);
                Armor Jedi_Robe = new Armor("Jedi Robe",0,1000,0,0);
                Obi_Wan.Equip(Jedi_Robe);
                return Obi_Wan;

            default:
                Random rand = new Random();
                int a;
                a=rand.nextInt(4);
                switch (a){
                    case 0:
                        Mage mage1 = new Mage("Xardas",80,120,10,0,5,1,new ArrayList(),new ArrayList());mage1.addSkills();
                        return mage1;
                    case 1:
                        Priest priest1 = new Priest("Priest",110,90,15,0,5,1,new ArrayList(),new ArrayList());
                        priest1.addSkills();
                        return priest1;
                    case 2:
                        Thief thief1 = new Thief("Thief",100,70,20,0,10,1,new ArrayList(),new ArrayList());
                        thief1.addSkills();
                        return thief1;
                    case 3:
                        Warrior warrior1 = new Warrior("Warrior",130,50,25,0,15,1,new ArrayList(),new ArrayList());
                        warrior1.addSkills();
                        return warrior1;
                }
                Mage useless = new Mage("Useless",0,0,0,0,0,0,new ArrayList(),new ArrayList());
                return useless;
        }

    }

    private void showHeroes(){
        Log.info("1.Mage");
        Log.info("2.Priest");
        Log.info("3.Thief");
        Log.info("4.Warrior");
    }

}
