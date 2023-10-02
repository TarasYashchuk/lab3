package Droids;

import Weapons.MeeleWeapon;
import Weapons.Weapon;

public class Warrior<T extends MeeleWeapon> extends Droid<Weapon>{

    double missChance;

    @Override
    public void passiveAbility(Droid<Weapon> droid) {
        if (Math.random() <= missChance) {
            System.out.println("Вампіризм! " + getName() + " відновив здоров'я від удару " + droid.getName());
            increaseHealth(droid.getWeapon().getDamage());
        }
    }
    @Override
    public void attack(Droid<Weapon> droid) {
        int damage = getWeapon().getDamage();
        System.out.println(getName() + " піднімає свій важкий меч із загостреним кінцем та замахується ним на " + droid.getName() + " і завдав йому " + damage + " шкоди");
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
                "Пасивне вміння - з ймовірністю 20% відновлює здоров'я рівноцінне шкоді зброї противника" + "\n" +
                "------------------------------------------------------------------";
    }

    public Warrior(Weapon weapon, String name, int health,double missChance){
        super(weapon, name, health);
        this.missChance = missChance;
    }

    public double getMissChance(){
        return missChance;
    }

    public void setMissChance(double missChance){
        this.missChance = missChance;
    }
}
