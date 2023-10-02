package BattleArena;

import Droids.Droid;

import java.util.List;


public class Info {

    static void availableDroids(List<Droid> droids) {
        System.out.println("Доступні дроїди:");
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + ". " + droids.get(i).getName());
        }
    }
     static void droidsInfo(List<Droid> droids){
        for (Droid droid : droids) {
            System.out.println(droid.toString());
        }
    }
}
