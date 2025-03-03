import java.util.Random;

public class Monster extends Character{

    public Monster(String name, int health, int damage, int healAmount, int maxHealth) {
        super(name, health, damage, healAmount, maxHealth);
    }

    Random random = new Random();

    private final int damage = random.nextInt(6) + 10;

    @Override
    public int getDamage() {
        return damage;
    }

    public void takeTurn(Character opponent) {
        int action = random.nextInt(3) + 1;
        if(action == 1) {
            if(chanceOfHit(opponent)) {
                System.out.println("\n" + getName() + " rolled more then " + opponent.getArmorClass());
                attack(opponent);
            }else {
                System.out.println("\n" + getName() + " rolled less then " + opponent.getArmorClass() + " and miss");
            }
        } else if (action == 2 && getHealth() < getMaxHealth()) {
            heal();
        }else {
            System.out.println("\n" + getName() + " skip his turn");
        }
    }
}
