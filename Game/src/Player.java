import java.util.Scanner;

class Player extends Character {
    /*public Player (String name, int health, int maxHealth, int damage, int healAmount) {
        super(name, health, maxHealth, damage, healAmount);
    }*/

    public void takeTurn(Character opponent) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nYour turn. Choose the action.");
        System.out.println("1 - attack");
        System.out.println("2 - heal");
        System.out.println("3 - skip");

        int choice = scanner.nextInt();
        switch(choice) {
            case 1 -> attack(opponent);
            case 2 -> heal();
            case 3 -> skip();
            default -> System.out.println("incorrect choice. Try again.");
        }
        //scanner.close();
    }
}