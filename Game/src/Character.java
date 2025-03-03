import java.util.List;
import java.util.Random;

public class Character {

    private final String name;
    private int health;
    private final int maxHealth;
    private final int damage;
    private final int healAmount;
    private int armorClass;
    private List<Character> enemies;

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

    public void setEnemies(List<Character> enemies) {
        this.enemies = enemies;
    }

    public List<Character> getEnemies() {
        return enemies;
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

    public boolean chanceOfHit(Character player) {
        Random random = new Random();

        int chance = random.nextInt(20) + 1;
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
}







