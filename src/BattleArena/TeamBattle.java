package BattleArena;

import Arena.Arena;
import Arena.*;
import Droids.*;
import Weapons.*;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static BattleArena.Info.availableDroids;
import static Droids.Droid.battle;

public class TeamBattle {

    public static void startDuelBattle(){

        Scanner scanner = new Scanner(System.in);

        List<Droid> droids = createDroids();

        chooseArena(scanner, droids);

        availableDroids(droids);

        createTeams teams = getCreatedTeams(scanner, droids);

        printInfoAboutTeams(teams);

        PrintWriter writer = getWriteToFile(scanner);

        teamBattle(teams, writer);
    }

    private static void teamBattle(createTeams teams, PrintWriter writer) {
        while (!teams.team1().isEmpty() && !teams.team2().isEmpty()) {
            // Перший дроїд з першої команди атакує першого дроїда з другої команди
            battle(teams.team1().get(0), teams.team2().get(0), writer);
            // Другий дроїд з першої команди атакує другого дроїда з другої команди
            battle(teams.team1().get(1), teams.team2().get(1), writer);
            // Перший дроїд з другої команди атакує другого дроїда з першої команди
            battle(teams.team2().get(0), teams.team1().get(1), writer);
            // Другий дроїд з другої команди атакує першого дроїда з першої команди
            battle(teams.team2().get(1), teams.team1().get(0), writer);
            // Перевірка на живих дроїдів і видалення мертвих з команд
            teams.team1().removeIf(droid -> droid.getHealth() <= 0);
            teams.team2().removeIf(droid -> droid.getHealth() <= 0);
        }

        if (writer != null) {
            writer.close();
        }

        if (teams.team1().isEmpty()) {
            System.out.println("Перемогла друга команда!");
        } else {
            System.out.println("Перемогла перша команда!");
        }
    }

    private static PrintWriter getWriteToFile(Scanner scanner) {
        System.out.println("Бажаєте записати хід бою у текстовий файл? (Так/Ні): ");
        String saveToFileChoice = scanner.next().toLowerCase();

        PrintWriter writer = null;

        if (saveToFileChoice.equals("так")) {
            try {
                System.out.println("Введіть ім'я файлу для збереження ходу бою: ");
                String fileName = scanner.next();
                writer = new PrintWriter(new FileOutputStream(fileName + ".txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return writer;
    }

    private static void printInfoAboutTeams(createTeams teams) {
        System.out.println("Команда 1 і її дроїди:");
        for (Droid droid : teams.team1()) {
            System.out.println(droid.getName());
        }

        System.out.println("Команда 2 і її дроїди:");
        for (Droid droid : teams.team2()) {
            System.out.println(droid.getName());
        }
    }

    private static createTeams getCreatedTeams(Scanner scanner, List<Droid> droids) {
        List<Droid> team1 = new ArrayList<>();
        System.out.println("Оберіть 2 дроїдів для першої команди:");
        chooseDroids(scanner, droids, team1);

        List<Droid> team2 = new ArrayList<>();
        System.out.println("Оберіть 2 дроїдів для другої команди:");
        chooseDroids(scanner, droids, team2);
        createTeams teams = new createTeams(team1, team2);
        return teams;
    }

    private static void chooseDroids(Scanner scanner, List<Droid> droids, List<Droid> team1) {
        for (int i = 0; i < 2; i++) {
            int choice1 = scanner.nextInt();
            if (choice1 >= 1 && choice1 <= droids.size()) {
                Droid droid1 = droids.get(choice1 - 1);

                team1.add(droid1);
            } else {
                System.out.println("Некоректний вибір, спробуйте ще раз.");
                i--;
            }
        }
    }

    private record createTeams(List<Droid> team1, List<Droid> team2) {
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

    public static List<Droid> createDroids() {

        List<Droid> droids = new ArrayList<>();

        droids.add(new Archer<Bow>(new Bow(), "Archer", 150, 0.20));
        droids.add(new Warrior<Sword>(new Sword(), "Warrior", 110, 0.35));
        droids.add(new Healer<SpecialWand>(new SpecialWand(), "Healer", 100, 5, 0.20));
        droids.add(new Tank<Shield>(new Shield(), "Tank", 200));
        droids.add(new Mage<MagicWand>(new MagicWand(), "Mage", 100, 0.10));

        return droids;
    }
}


