import java.util.Random;
import java.util.Scanner;

class Character {
    String name;
    int health;
    int maxHealth;

    public Character (String name, int health) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public void attack (Character target) {
        int damage = 10;
        target.health -= damage;
        if(target.health < 0) {
            target.health = 0;
        }
        System.out.println(name + " attacked " + target.name + " and deals " + damage + " damage");
    }

    public void heal() {
        int healAmount = 15;
        health += healAmount;
        if(health > maxHealth) {
            health = maxHealth;
        }
        System.out.println(name + " restored " + healAmount + " HP");
    }

    public void skip () {
        System.out.println(name + " misses a turn");
    }

    public boolean isAlive() {
        return health > 0;
    }
}

public class MonsterGame {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Character player = new Character ("Player", 100);
        Character monster = new Character("Monster", 100);

        System.out.println("The game begins");

        while (player.isAlive() && monster.isAlive()) {
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