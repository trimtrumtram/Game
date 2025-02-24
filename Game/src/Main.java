public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.setName("Me");
        player.setHealth(100);
        player.setDamage(15);
        player.setMaxHealth(150);
        player.setHealAmount(10);

        Monster monster = new Monster();
        monster.setName("Demon");
        monster.setHealth(100);
        monster.setDamage(15);
        monster.setMaxHealth(150);
        monster.setHealAmount(5);

        System.out.println("The game begins");

        while(player.isAlive() && monster.isAlive()) {

            System.out.println("player " + player.getHealth() + "HP");
            System.out.println("monster " + monster.getHealth() + "HP");

            player.takeTurn(monster);

            if(monster.isAlive()){
                monster.takeTurn(player);
            }
        }

        if(player.isAlive()){
            System.out.println("Congratulations. You win!");
        } else {
            System.out.println("You lose. Try again");
        }
    }
}
