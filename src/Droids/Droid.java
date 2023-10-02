package Droids;

import Weapons.*;

import java.io.PrintWriter;

public abstract class Droid<T extends Weapon>{

    private String name;
    private int health;
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }
    public abstract void passiveAbility(Droid<T> droid);
    public abstract void attack(Droid<T> droid);

    public static void battle(Droid droid1, Droid droid2, PrintWriter writer) {
        int round = 1;
        while (droid1.getHealth() > 0 && droid2.getHealth() > 0) {
            String roundInfo = "--------------------------\n" +
                    "Раунд " + round + "\n" +
                    droid1.getName() + " має " + droid1.getHealth() + " здоров'я.\n" +
                    droid2.getName() + " має " + droid2.getHealth() + " здоров'я.\n";

            System.out.println(roundInfo);

            if (writer != null) {
                writer.println(roundInfo);
            }

            droid1.attack(droid2);

            String droid1Action = droid1.getName() + " вдарив " + droid2.getName() + " і завдав " + droid1.getWeapon().getDamage() + " пошкодження.";

            if (writer != null) {
                writer.println(droid1Action);
            }

            if (isAlive(droid2, writer)) break;

            droid2.attack(droid1);

            String droid2Action = droid2.getName() + " вдарив " + droid1.getName() + " і завдав " + droid2.getWeapon().getDamage()+ " пошкодження.";

            if (writer != null) {
                writer.println(droid2Action);
            }

            if (isAlive(droid1, writer)) break;
            round++;
        }

        battleResult(droid1, droid2, writer);
        if (writer != null) {
            writer.close();
        }
    }

    private static void battleResult(Droid droid1, Droid droid2, PrintWriter writer) {
        if (droid1.getHealth() > 0) {
            String winMessage = droid1.getName() + " переміг у бою!";

            System.out.println(winMessage);

            if (writer != null) {
                writer.println(winMessage);
            }
        } else if (droid2.getHealth() > 0) {
            String winMessage = droid2.getName() + " переміг у бою!";


            System.out.println(winMessage);

            if (writer != null) {
                writer.println(winMessage);
            }
        } else {
            String drawMessage = "Бій завершився внічию.";

            System.out.println(drawMessage);

            if (writer != null) {
                writer.println(drawMessage);
            }
        }
    }

    private static boolean isAlive(Droid droid2, PrintWriter writer) {
        if (droid2.getHealth() <= 0) {
            String defeatedMessage = droid2.getName() + " вибув з гри.";

            if (writer != null) {
                writer.println(defeatedMessage);
            }
            return true;
        }
        return false;
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void increaseHealth(int health){
        this.health += health;
    }

    public Droid(Weapon weapon, String name, int health){
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

}
