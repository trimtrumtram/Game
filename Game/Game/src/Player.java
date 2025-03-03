import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Player extends Character{

    public Player(String name, int health, int damage, int healAmount, int maxHealth) {
        super(name, health, damage, healAmount, maxHealth);
    }

    private int criticalDamage;
    private int diceCount1d15;

    public int getDiceCount1d15() {
        return diceCount1d15;
    }

    public void setDiceCount1d15(int diceCount1d15) {
        this.diceCount1d15 = diceCount1d15;
    }

    Scanner scanner = new Scanner(System.in);

    public void criticalHit (Character opponent) {
        System.out.println("\n" + getName() + " attacked " + opponent.getName() + " and deals " + criticalDamage + " damage");
        opponent.takeDamage(criticalDamage);
    }

    public void attackTarget() {
        List<Character> enemies = getEnemies();
        if(enemies == null || enemies.isEmpty()) {
            System.out.println("No enemies");
            return;
        }

        System.out.println("choose an enemy:");
        for (int i = 0; i < enemies.size(); ++i) {
            if(enemies.get(i).isAlive()) {
                System.out.println((i + 1) + " - " + enemies.get(i).getName());
            }
        }

        int targetIndex = scanner.nextInt() - 1;
        if(targetIndex >= 0 && targetIndex < enemies.size() && enemies.get(targetIndex).isAlive()) {
            Character target = enemies.get(targetIndex);
            int attackDamage = getDamage();

            Random random = new Random();
            setDiceCount1d15(random.nextInt(15) + 1);

            if(getDiceCount1d15()>= 10) {
                criticalDamage = attackDamage + getDiceCount1d15();
                System.out.println("Critical damage " + criticalDamage);
                criticalHit(target);
            }else {
                System.out.println("You attacked " + target.getName() + " and deal " + attackDamage + " damage");
                target.takeDamage(attackDamage);
            }

        } else {
            System.out.println("Incorrect choice. Skip action");
        }
    }

    public void takeTurn() {

        System.out.println("\nYour turn. Choose the action.");
        System.out.println("1 - attack");
        System.out.println("2 - heal");
        System.out.println("3 - skip");

        int choice = scanner.nextInt();
        switch(choice) {
            case 1 -> attackTarget();
            case 2 -> heal();
            case 3 -> skip();
            default -> System.out.println("incorrect choice. Try again.");
        }
    }
}
