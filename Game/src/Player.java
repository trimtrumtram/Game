import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Player extends Character{

    public Player(String name, int health, int damage, int healAmount, int maxHealth) {
        super(name, health, damage, healAmount, maxHealth);
    }

    Random random = new Random();

    private int criticalDamage;
    private final int diceCount = random.nextInt(15) + 1;

    public int getDiceCount() {
        return diceCount;
    }

    Scanner scanner = new Scanner(System.in);

    private void criticalHit (Character opponent) {
        System.out.println("\n" + getName() + " attacked " + opponent.getName() + " and deals " + criticalDamage + " damage");
        opponent.takeDamage(criticalDamage);
    }

    @Override
    protected Character chooseEnemy(List<Character> enemies) {
        System.out.println("choose an enemy:");
        for (int i = 0; i < enemies.size(); ++i) {
            if(enemies.get(i).isAlive()) {
                System.out.println((i + 1) + " - " + enemies.get(i).getName());
            }
        }

        int targetIndex = scanner.nextInt() - 1;
        return enemies.get(targetIndex);
    }

    private void rollTheDice (List<Character> enemies) {
        Character target = chooseEnemy(enemies);
        if(target == null || !target.isAlive()) {
            System.out.println("Incorrect choice. Skip action");
            return;
        }

        if(diceCount >= 10) {
            criticalDamage = getDamage() + getDiceCount();
            System.out.println("Critical damage " + criticalDamage);
            criticalHit(target);
        }else {
            System.out.println("You attacked " + target.getName() + " and deal " + getDamage() + " damage");
            target.takeDamage(getDamage());
        }
    }

    private void attackTarget(List<Character> enemies) {
        if(enemies == null || enemies.isEmpty()) {
            System.out.println("No enemies");
            return;
        }

        rollTheDice(enemies);
    }

    @Override
    public void takeTurn(List<Character> enemies) {

        System.out.println("\nYour turn. Choose the action.");
        System.out.println("1 - attack");
        System.out.println("2 - heal");
        System.out.println("3 - skip");

        int choice = scanner.nextInt();
        switch(choice) {
            case 1 -> attackTarget(enemies);
            case 2 -> heal();
            case 3 -> skip();
            default -> System.out.println("incorrect choice. Try again.");
        }
    }
}

