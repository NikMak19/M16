import java.util.Scanner;

public class Game {
    private Player player;
    private boolean hasTraderArrived;

    public Game() {
        hasTraderArrived = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        createPlayer(scanner);
        showMainMenu(scanner);
    }

    private void createPlayer(Scanner scanner) {
        System.out.println("Добро пожаловать в игру!");
        System.out.print("Введите имя вашего персонажа: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName, 100, 10, 5);
        System.out.println("Персонаж " + playerName + " создан!");
    }

    private void showMainMenu(Scanner scanner) {
        while (player.isAlive()) {
            System.out.println("\nКуда вы хотите пойти?");
            System.out.println("1. К торговцу");
            System.out.println("2. В тёмный лес");
            System.out.println("3. На выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    visitTrader();
                    break;
                case 2:
                    startBattle();
                    break;
                case 3:
                    System.out.println("Вы покидаете игру. До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }

    private void visitTrader() {
        if (!hasTraderArrived) {
            System.out.println("Торговец еще не вышел на работу.");
        } else {
            // Логика взаимодействия с торговцем
            System.out.println("Добро пожаловать к торговцу!");
        }
    }

    private void startBattle() {
        System.out.println("Вы входите в тёмный лес...");

        Monster[] monsters = {
                new Monster("Скелет", 50, 5, 2, 20, 10),
                new Monster("Гоблин", 60, 8, 3, 30, 15)
        };

        int randomIndex = Math.random() < 0.5 ? 0 : 1;
        Monster monster = monsters[randomIndex];

        System.out.println("Вы столкнулись с " + monster.getName() + "!");

        Battle battle = new Battle(player, monster);
        battle.startBattle();

        if (player.isAlive()) {
            System.out.println("Вы победили в бою!");
            showContinueOptions();
        } else {
            System.out.println("Вы погибли в бою. Игра окончена.");
        }
    }

    private void showContinueOptions() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Вернуться в город");
            System.out.println("2. Продолжить торговлю/бой");

            int choice = scanner.nextInt();

            if (choice == 1) {
                showMainMenu(scanner);
                break;
            } else if (choice == 2) {
                visitTrader();
                break;
            } else {
                System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}