import java.util.List;
import java.util.Random;

public class Archer extends Character{

    public Archer(String name, int health, int damage, int healAmount, int maxHealth) {
        super(name, health, damage, healAmount, maxHealth);
    }

    Random random = new Random();

    private int turnCounter = 0;
    private int extraDamage;

    public int getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(int extraDamage) {
        this.extraDamage = extraDamage;
    }

    @Override
    protected Character chooseEnemy(List<Character> opponents) {
        System.out.println("choose an enemy:");
        for (int i = 0; i < opponents.size(); ++i) {
            if(opponents.get(i).isAlive()) {
                System.out.println((i + 1) + " - " + opponents.get(i).getName());
            }
        }
        return opponents.stream()
                .filter(Character::isAlive)
                .findFirst()
                .orElse(null);
    }

    public void takeTurn(List<Character> opponents) {
        Character opponent = chooseEnemy(opponents);

        if(opponent != null) {
            turnCounter++;

            if (turnCounter % 3 == 0) {
                specialAttack(opponent);
                int healAmount = getExtraDamage();
                setHealth(getHealth() + healAmount);
            } else {
                attack(opponent);
            }
        }
    }

    private void specialAttack(Character opponent) {
        setExtraDamage(getDamage() + random.nextInt(10) + 1);
        System.out.println("\n" + getName() + " use the special attack. Deal " + getExtraDamage() + " damage and heal " + getExtraDamage() + " HP");
        opponent.takeDamage(getExtraDamage());
    }
}
