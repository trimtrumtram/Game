import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Player extends Character{

    public Player(String name, int health, int damage, int healAmount, int maxHealth) {
        super(name, health, damage, healAmount, maxHealth);
    }

    private int criticalDamage;

    Random random = new Random();
    private final int diceCount = random.nextInt(15) + 1;

    public int getDiceCount() {
        return diceCount;
    }

    Scanner scanner = new Scanner(System.in);

    public void criticalHit (Character opponent) {
        System.out.println("\n" + getName() + " attacked " + opponent.getName() + " and deals " + criticalDamage + " damage");
        opponent.takeDamage(criticalDamage);
    }

    public void rollTheDice (List<Character> enemies) {
        int targetIndex = chooseEnemy(enemies);
        if(!isValidTarget(targetIndex, enemies)) {
            System.out.println("Incorrect choice. Skip action");
            return;
        }

        Character target = enemies.get(targetIndex);
        int attackDamage = getDamage();

        if(diceCount >= 10) {
            criticalDamage = attackDamage + getDiceCount();
            System.out.println("Critical damage " + criticalDamage);
            criticalHit(target);
        }else {
            System.out.println("You attacked " + target.getName() + " and deal " + attackDamage + " damage");
            target.takeDamage(attackDamage);
        }
    }

    public void attackTarget(List<Character> enemies) {
        if(enemies == null || enemies.isEmpty()) {
            System.out.println("No enemies");
            return;
        }

        rollTheDice(enemies);
    }

    private boolean isValidTarget(int index, List<Character> enemies) {
        return index >= 0 && index < enemies.size() && enemies.get(index).isAlive();
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

