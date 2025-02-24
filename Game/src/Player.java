import java.util.Scanner;

class Player extends Character {

    Scanner scanner = new Scanner(System.in);

    public void attackTarget(Character monster, Character rogue) {
        System.out.println("Who will be attack?");
        System.out.println("1 - monster");
        System.out.println("2 - rogue");

        int target = scanner.nextInt();

        if(target == 1 && monster.isAlive()) {
            System.out.println("You attacked the monster and deal " + getDamage() + " damage");
            monster.takeDamage(getDamage());
        } else if (target == 2 && rogue.isAlive()) {
            System.out.println("You attacked the rogue and deal " + getDamage() + " damage");
            rogue.takeDamage(getDamage());
        }
    }

    public void takeTurn(Character monster, Character rogue) {

        System.out.println("\nYour turn. Choose the action.");
        System.out.println("1 - attack");
        System.out.println("2 - heal");
        System.out.println("3 - skip");

        int choice = scanner.nextInt();

        switch(choice) {
            case 1 -> attackTarget(monster, rogue);
            case 2 -> heal();
            case 3 -> skip();
            default -> System.out.println("incorrect choice. Try again.");
        }
    }
}