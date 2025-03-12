import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Character {

    private final String name;
    private int health;
    private final int maxHealth;
    private final int damage;
    private final int healAmount;
    private int armorClass;

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private final int chance = random.nextInt(20) + 1;

    public Character(String name, int health, int damage, int healAmount, int maxHealth) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.healAmount = healAmount;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if(health < 0) {
            health = 0;
        }
    }

    public void attack (Character opponent) {
        System.out.println("\n" + name + " attacked " + opponent.name + " and deals " + damage + " damage");
        opponent.takeDamage(damage);
    }

    public int chooseEnemy(List<Character> enemies) {
        System.out.println("choose an enemy:");
        for (int i = 0; i < enemies.size(); ++i) {
            if(enemies.get(i).isAlive()) {
                System.out.println((i + 1) + " - " + enemies.get(i).getName());
            }
        }

        return scanner.nextInt() - 1;
    }

    public boolean chanceOfHit(Character player) {
        return chance >= player.getArmorClass();
    }

    public void heal() {
        health += healAmount;
        if(health > maxHealth) {
            health = maxHealth;
        }
        System.out.println("\n" + name + " restored " + healAmount + " HP");
    }

    public void skip() {
        System.out.println("\n" + name + " misses a turn");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void takeTurn(List<Character> opponents);
}







