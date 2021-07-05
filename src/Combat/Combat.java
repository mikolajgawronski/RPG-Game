package Combat;

import Enemies.Enemy;
import Heroes.Hero;

import java.util.ArrayList;
import java.util.Collections;

public class Combat {

    ArrayList<Object> Fighters = new ArrayList<>();

    public Combat() {
    }

    public void Fight(ArrayList<Hero> YourHero,ArrayList<Enemy> Enemies){

        Fighters.add(YourHero.get(0));

        for (int i=0;i<Enemies.size();i++) {
            Fighters.add(Enemies.get(i));
        }

        YourHero.get(0).getEnemies(Enemies);

        while(true) {
            int deadMonsters=0;
            for (Enemy name : Enemies) {
                name.setHeroes(YourHero);
                name.Attack();
            }

            YourHero.get(0).whatToDo();

            for (Enemy name : Enemies) {
                if(name.getHp()<=0){
                    deadMonsters++;
                }
            }

            if(deadMonsters==Enemies.size()){
                YourHero.get(0).checkifLevelUp();
                YourHero.get(0).searchForLoot();
                break;
            }
        }







    }

}
