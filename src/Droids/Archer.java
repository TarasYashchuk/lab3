package Droids;

import Weapons.RangeWeapon;
import Weapons.Weapon;

public class Archer<T extends RangeWeapon> extends Droid<Weapon>{

    private double doubleAttackChance;

    @Override
    public void passiveAbility(Droid<Weapon> droid){
        if (Math.random() < doubleAttackChance) {
            System.out.println(getName() + " атакує ще раз!");
            attack(droid);
        }
    }

    @Override
    public void attack(Droid<Weapon> droid){
        int damage = getWeapon().getDamage();
        System.out.println(getName() + " розтягує свій міцний лук, натягує стрілу з енергетичного матеріалу та направляє його на "
                + droid.getName() + " і завдає йому " + getWeapon().getDamage() + " шкоди");
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
                "Пасивне вміння - з ймовірністю 20% вистрілити у противника ще раз" + "\n" +
                "------------------------------------------------------------------";
    }

    public Archer(T weapon, String name, int health, double doubleAttackChance){
        super(weapon,name,health);
        this.doubleAttackChance = doubleAttackChance;
    }


}
