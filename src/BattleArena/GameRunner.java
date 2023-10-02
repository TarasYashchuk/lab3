package BattleArena;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        do {
            message();

            System.out.println("\u001B[31m1 >> Битва 1 на 1");
            System.out.println("2 >> Битва 2 на 2");
            System.out.println("3 >> Інформація про дроїдів");
            System.out.println("4 >> Вихід\u001B[0m");
            System.out.println();
            System.out.print("Ваш вибір >> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            menu.handleChoice(choice);

            System.out.println("Бажаєте продовжити? (так/ні): ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("так")) {
                break;
            }
        } while (true);
    }

    private static void message() {
        System.out.println("██████╗   ███████╗        ████      ██   ██████╗          ████████╗     █████╗   ████████   ████████   ██        ██████");
        System.out.println("██║   ██  ██║     ██   ██║    ██         ██║   ██         ██║    ██   ██     ██     ██         ██      ██        ██       ");
        System.out.println("██║   ██  ██║     ██   ██║    ██    ██   ██║   ██         █████████   ██  █  ██     ██         ██      ██        ██        ");
        System.out.println("██║   ██  ████████     ██║    ██    ██   ██║   ██         ██║    ██   ████ ████     ██         ██      ██        ██████    ");
        System.out.println("██╝   ██  ██║  ███     ██║    ██    ██   ██╝   ██         ██╝    ██   ██     ██     ██         ██      ██        ██        ");
        System.out.println("██████╝   ██║    ██       ████      ██   ██████╗          ████████╝   ██     ██     ██         ██      ████████  ██████    ");
        System.out.println();
        System.out.println();
        System.out.println("██████   ██   ██     █ ██ █     █ ██ █      ██████   █████                █ ██ █    ███████    ████████   ██    █ ██ █     ████     ██                    ");
        System.out.println("██       ██   ██    ██    ██   ██    ██    ██        ██                  ██    ██   ██   ██       ██      ██   ██    ██    ██  ██   ██             ");
        System.out.println("██       ███████    ██    ██   ██    ██       ██     █████               ██    ██   ███████       ██      ██   ██    ██    ██   ██  ██             ");
        System.out.println("██       ██   ██    ██    ██   ██    ██         ██   ██                  ██    ██   ██            ██      ██   ██    ██    ██    ██ ██                 ");
        System.out.println("██████   ██   ██     █ ██ █     █ ██ █    ██████     █████                █ ██ █    ██            ██      ██    █ ██ █     ██      ███                     ");
        System.out.println();
        System.out.println();

    }
}
