public class Main {
    public static void main(String[] args) {

        Player player = new Player();
        player.setName("Me");
        player.setHealth(100);
        player.setDamage(15);
        player.setMaxHealth(150);
        player.setHealAmount(10);
        player.setArmorClass(10);

        Monster monster = new Monster();
        monster.setName("Demon");
        monster.setHealth(100);
        monster.setDamage(15);
        monster.setMaxHealth(150);
        monster.setHealAmount(10);

        Rogue rogue = new Rogue();
        rogue.setName("rogue");
        rogue.setHealth(100);
        rogue.setDamage(rogue.damage);
        rogue.setMaxHealth(150);
        rogue.setHealAmount(10);

        System.out.println("The game begins");

        while(player.isAlive() && monster.isAlive() && rogue.isAlive()) {

            System.out.println("\nplayer " + player.getHealth() + "HP");
            System.out.println("monster " + monster.getHealth() + "HP");
            System.out.println("rogue " + rogue.getHealth() + "HP");

            player.takeTurn(monster, rogue);

            if(monster.isAlive()){
                monster.takeTurn(player);
            }

            if(rogue.isAlive()) {
                rogue.takeTurn(player);
            }
        }

        if(player.isAlive()){
            System.out.println("Congratulations. You win!");
        } else {
            System.out.println("You lose. Try again");
        }
    }
}
