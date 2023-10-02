package Droids;

import Weapons.DefenceWeapon;
import Weapons.Weapon;


public class Tank<T extends DefenceWeapon> extends Droid<Weapon>{

    @Override
    public void passiveAbility(Droid<Weapon> droid) {
         int lowerDamage = (int) (droid.getWeapon().getDamage() * 0.8);
         decreaseHealth(lowerDamage);
    }

    @Override
    public void attack(Droid<Weapon> droid) {
        int damage = getWeapon().getDamage();
        passiveAbility(droid);
        droid.decreaseHealth(getWeapon().getDamage());
        System.out.println(getName() + " вдягнувши потужну броню, піднімає величезний щит та блокує " + droid.getWeapon().getDamage() * 0.8 + " шкоди від " +
                droid.getName() + " та завдає йому " + damage + " шкоди");
    }

    @Override
    public String toString(){
        return "------------------------------------------------------------------" + "\n" +
                "Ім'я: " + getName() + "\n" +
                "Здоров'я: " + getHealth() + "\n" +
                "Зброя: " + getWeapon().getName() + "\n" +
                "Шкода зброї: " + getWeapon().getDamage() + "\n" +
                "Пасивне вміння - отримує на 20% менше шкоди від ударів противника" +"\n" +
                "------------------------------------------------------------------";
    }

    public Tank(Weapon weapon, String name, int health){
        super(weapon, name, health);
    }
}
