import java.util.Random;

class Monster extends Character {

    Random random = new Random();

    public void takeTurn(Character opponent) {
        int action = random.nextInt(3) + 1;
        if(action == 1) {
            if(chanceOfHit()) {
                System.out.println("\n" + getName() + " rolled more then 10" );
                attack(opponent);
            }else {
                System.out.println("\n" + getName() + " rolled less then 10 and miss");
            }
        } else if (action == 2 && getHealth() < getMaxHealth()) {
            heal();
        }else {
            System.out.println("\n" + getName() + " skip his turn");
        }
    }
}
