package Droids;

import Weapons.MagicWeapon;
import Weapons.Weapon;

public class Mage<T extends MagicWeapon> extends Droid<Weapon>{

    private double oneShotChance;

    @Override
    public void passiveAbility(Droid<Weapon> droid) {
        if(Math.random() <= oneShotChance){
            System.out.println("НЕБЕСНА КАРА " + getName() + " моментально вбиває " + droid.getName());
            droid.decreaseHealth(droid.getHealth());
        }
    }

    @Override
    public void attack(Droid<Weapon> droid) {
        int damage = getWeapon().getDamage();
        System.out.println(getName() + " піднімає свою руку, обвіювану магічними аурою, і накидує закляття на " + droid.getName() +
                " та завдає йому " + damage + " шкоди");
        droid.decreaseHealth(damage);
        passiveAbility(droid);
    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "Ім'я: " + getName() + "\n" +
                "Здоров'я: " + getHealth() + "\n" +
                "Зброя: " + getWeapon().getName() + "\n" +
                "Шкода зброї: " + getWeapon().getDamage() + "\n" +
                "Пасивне вміння - з ймовірністю 10% моментально вбиває противника" +"\n" +
                "------------------------------------------------------------------";
    }

    public Mage(Weapon weapon, String name, int health, double oneShotChance){
        super(weapon, name, health);
        this.oneShotChance = oneShotChance;
    }
}
