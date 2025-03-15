import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Player player = new Player(
                "warrior",
                100,
                30,
                15,
                150
        );
        player.setArmorClass(10);

        Monster monster = new Monster(
                "monster",
                100,
                10,
                10,
                150
        );

        Monster rogue = new Monster(
                "rogue",
                100,
                monster.getDamage(),
                10,
                150
            );

        Archer archer = new Archer(
                "archer",
                50,
                10,
                10,
                150
        );

        List<Character> enemies = new ArrayList<>();
        enemies.add(monster);
        enemies.add(rogue);
        enemies.add(archer);

        System.out.println("The game begins");

        while(player.isAlive() && enemies.stream().anyMatch(Character::isAlive)) {

            System.out.println("\nplayer " + player.getHealth() + "HP");
            System.out.println("monster " + monster.getHealth() + "HP");
            System.out.println("rogue " + rogue.getHealth() + "HP");
            System.out.println("archer " + archer.getHealth() + "HP");

            player.takeTurn(enemies);

            for (Character enemy : enemies) {
                if(enemy.isAlive()) {
                    enemy.takeTurn(List.of(player));
                }
            }
        }

        if(player.isAlive()){
            System.out.println("Congratulations. You win!");
        } else {
            System.out.println("You lose. Try again");
        }
    }
}
