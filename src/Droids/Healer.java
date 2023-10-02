package Droids;

import Weapons.SpecialWeapon;
import Weapons.Weapon;


public class Healer<T extends SpecialWeapon> extends Droid {

    int healRate;
    double healChance;

   public Healer(Weapon weapon, String name, int health, int healRate, double healChance){
       super(weapon,name,health);
       this.healChance = healChance;
       this.healRate = healRate;
   }

    @Override
    public void passiveAbility(Droid droid) {
           if(Math.random() <= healChance){
               System.out.println("Спасіння! " + getName() + " вилікував себе на " + droid.getHealth() / 2);
               increaseHealth(droid.getWeapon().getDamage());
           }
    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "Ім'я: " + getName() + "\n" +
                "Здоров'я: " + getHealth() + "\n" +
                "Зброя: " + getWeapon().getName() + "\n" +
                "Шкода зброї: " + getWeapon().getDamage() + "\n" +
                "Активне вміння - кожного разу відновлює собі 5 одиниць здоров'я" + "\n" +
                "Пасивне вміння - з ймовірністю 20% відновлює собі здоров'я на половину здоров'я противника" + "\n" +
                "------------------------------------------------------------------";
    }

    @Override
    public void attack(Droid droid) {
        int damage = getWeapon().getDamage();
        System.out.println(getName() + " завдав " +  getWeapon().getDamage() + " шкоди " + droid.getName() + " та вилікував себе на " + getHealRate() + " здоров'я");
        droid.decreaseHealth(damage);
        increaseHealth(healRate);
        passiveAbility(droid);

    }

    public int getHealRate() {
        return healRate;
    }
}



