import java.util.Random;

abstract class Character {
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    private int healAmount;
    private int armorClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public void takeDamage (int damage)  {
        setHealth(getHealth() - damage);
        if(getHealth() < 0) {
            setHealth(0);
        }
    }

    public void attack(Character opponent) {
        System.out.println(name + " attacked " + opponent.name + " and deals " + damage + " damage");
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
