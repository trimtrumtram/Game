class Character {
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    private int healAmount;

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

    public void attack (Monster target)  {
        target.setHealth(health - damage);
        if(target.getHealth() < 0) {
            target.setHealth(0);
        }
        System.out.println(name + " attacked " + target.getName() + " and deals " + damage + " damage");
    }

    public void heal() {
        health += healAmount;
        if(health > maxHealth) {
            health = maxHealth;
        }
        System.out.println(name + " restored " + healAmount + " HP");
    }

    public void skip() {
        System.out.println(name + " misses a turn");
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }
}
