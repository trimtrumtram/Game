import java.util.List;
import java.util.Random;


public abstract class Character {

    private final String name;
    private int health;
    private final int maxHealth;
    private final int damage;
    private final int healAmount;
    private int armorClass;

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

    protected void attack (Character opponent) {
        System.out.println("\n" + name + " attacked " + opponent.name + " and deals " + damage + " damage");
        opponent.takeDamage(damage);
    }

    protected boolean chanceOfHit(Character player) {
        return chance >= player.getArmorClass();
    }

    protected void heal() {
        health += healAmount;
        if(health > maxHealth) {
            health = maxHealth;
        }
        System.out.println("\n" + name + " restored " + healAmount + " HP");
    }

    protected void skip() {
        System.out.println("\n" + name + " misses a turn");
    }

    protected boolean isAlive() {
        return health > 0;
    }

    protected abstract Character chooseEnemy(List<Character> enemies);

    protected abstract void takeTurn(List<Character> opponents);
}







