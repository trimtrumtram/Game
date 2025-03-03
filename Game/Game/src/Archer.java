import java.util.Random;

public class Archer extends Character{

    public Archer(String name, int health, int damage, int healAmount, int maxHealth) {
        super(name, health, damage, healAmount, maxHealth);
    }

    private int turnCounter = 0;
    private int extraDamage;

    public int getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(int extraDamage) {
        this.extraDamage = extraDamage;
    }

    Random random = new Random();

    public void shot(Character opponent) {
        turnCounter++;

        if(turnCounter % 3 == 0) {
            specialAttack(opponent);
            int healAmount = getExtraDamage();
            setHealth(getHealth() + healAmount);
        } else {
            attack(opponent);
        }
    }

    public void specialAttack(Character opponent) {
        setExtraDamage(getDamage() + random.nextInt(10) + 1);
        System.out.println("\n" + getName() + " use the special attack. Deal " + getExtraDamage() + " damage and heal " + getExtraDamage() + " HP");
        opponent.takeDamage(getExtraDamage());
    }
}
