import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Character player = new Character();
        player.setName("britni");
        player.setHealth(100);
        player.setDamage(15);
        player.setMaxHealth(150);
        player.setHealAmount(10);

        Monster monster = new Monster();
        monster.setName("Demon");
        monster.setHealth(100);
        monster.setDamage(15);
        monster.setMaxHealth(150);
        monster.setHealAmount(5);

        System.out.println("The game begins");

        while (player.isAlive() && monster.isAlive()) {
            System.out.println("\nmonster have " + monster.getHealth());
            System.out.println("player have " + player.getHealth());
            System.out.println("\nYour Turn. Choose an action:");
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Skip");

            int choise = scanner.nextInt();

            switch (choise) {
                case 1:
                    player.attack(monster);
                    break;
                case 2:
                    player.heal();
                    break;
                case 3:
                    player.skip();
                    break;
                default:
                    System.out.println("Incorrect choise. Skip");
                    break;
            }

            if (!monster.isAlive()) break;

            System.out.println("\nMonster turn.");
            int monsterAction = random.nextInt(3) + 1;

            switch (monsterAction) {
                case 1:
                monster.attack(player);
                    break;
                case 2:
                    monster.heal();
                    break;
                case 3:
                    monster.skip();
                    break;
            }
        }

        if(player.isAlive()) {
            System.out.println("\nYou win!");
        }
        else {
            System.out.println("\nYou lose! Try again");
        }

        scanner.close();
    }
}
