package BattleArena;

import Droids.Droid;

import java.util.List;

import static BattleArena.Info.droidsInfo;
import static BattleArena.TeamBattle.createDroids;

public class Menu {
    public void handleChoice(int choice) {

        List<Droid> droids = createDroids();

            switch (choice) {
                case 1:
                    DuelBattle.startDuelBattle();
                    break;
                case 2:
                    TeamBattle.startDuelBattle();
                    break;
                case 3: droidsInfo(droids);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
        }
    }
}
