package BattleArena;

import Droids.*;
import Arena.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import static BattleArena.Info.availableDroids;
import static BattleArena.TeamBattle.createDroids;
import static Droids.Droid.battle;

public class DuelBattle {
    public static void startDuelBattle() {
        Scanner scanner = new Scanner(System.in);

        List<Droid> droids = createDroids();

        chooseArena(scanner, droids);

        availableDroids(droids);

        System.out.print("Оберіть першого дроїда (введіть номер): ");

        int choice1 = scanner.nextInt();
        System.out.print("Оберіть другого дроїда (введіть номер): ");
        int choice2 = scanner.nextInt();

        if (choice1 >= 1 && choice1 <= droids.size() && choice2 >= 1 && choice2 <= droids.size()) {
            Droid droid1 = droids.get(choice1 - 1);
            Droid droid2 = droids.get(choice2 - 1);

            PrintWriter writer = getWriteToFile(scanner);

            battle(droid1, droid2, writer);

            if (writer != null) {
                writer.close();
            }
        } else {
            System.out.println("Некоректний вибір дроїдів.");
        }
    }

    private static PrintWriter getWriteToFile(Scanner scanner) {
        System.out.print("Бажаєте записати хід битви у текстовий файл? (Так/Ні): ");
        String saveToFileChoice = scanner.next().toLowerCase();

        PrintWriter writer = null;

        if (saveToFileChoice.equals("так")) {
            try {
                System.out.print("Введіть ім'я файлу для збереження ходу битви: ");
                String fileName = scanner.next();
                writer = new PrintWriter(new FileOutputStream(fileName + ".txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return writer;
    }

    private static void chooseArena(Scanner scanner, List<Droid> droids) {
        System.out.println("\u001B[34mВиберіть арену:");
        System.out.println("1 >> Арена зі зменшенням здоров'я на 30");
        System.out.println("2 >> Арена зі збільшенням здоров'я на 30");
        System.out.print("Ваш вибір >> \u001B[0m");
        int choice = scanner.nextInt();
        Arena selectedArena = null;
        switch (choice) {
            case 1:
                selectedArena = new Foog();
                break;
            case 2:
                selectedArena = new Heaven();
                break;
            default:
                System.out.println("Невірний вибір");
                break;
        }

        for (Droid droid : droids) {
            selectedArena.modifyDroidsStats(droid);
        }
    }
}

