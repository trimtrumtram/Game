import java.util.List;
import java.util.Random;

public class Monster extends Character{

    public Monster(String name, int health, int damage, int healAmount, int maxHealth) {
        super(name, health, damage, healAmount, maxHealth);
    }
    Random random = new Random();
    private final int action = random.nextInt(3) + 1;
    private final int damage = random.nextInt(6) + 10;

    @Override
    public int getDamage() {
        return damage;
    }

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

    @Override
    public void takeTurn(List<Character> opponents) {
        Character opponent = chooseEnemy(opponents);

        if (opponent != null){
            if (action == 1) {
                if (chanceOfHit(opponent)) {
                    System.out.println("\n" + getName() + " rolled more then " + opponent.getArmorClass());
                    attack(opponent);
                } else {
                    System.out.println("\n" + getName() + " rolled less then " + opponent.getArmorClass() + " and miss");
                }
            } else if (action == 2 && getHealth() < getMaxHealth()) {
                heal();
            } else {
                System.out.println("\n" + getName() + " skip his turn");
            }
        }
    }
}
