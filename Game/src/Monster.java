import java.util.Random;

class Monster extends Character {
    Random random = new Random();

    public void takeTurn(Character opponent) {
        int action = random.nextInt(3) + 1;
        if(action == 1) {
            attack(opponent);
        } else if (action == 2 && getHealth() < getMaxHealth()) {
            heal();
        }else {
            System.out.println(getName() + " skip his turn");
        }
    }
}
