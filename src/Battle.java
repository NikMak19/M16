import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private Player player;
    private Monster monster;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void startBattle() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            Random random = new Random();

            while (player.isAlive() && monster.isAlive()) {
                if (player.getAgility() * 3 > random.nextInt(101)) {
                    int playerDamage = player.getStrength();
                    monster.takeDamage(playerDamage);
                    System.out.println(player.getName() + " атакует " + monster.getName() + " и наносит " + playerDamage + " урона.");
                } else {
                    System.out.println(player.getName() + " промахивается!");
                }

                if (monster.isAlive()) {
                    if (monster.getAgility() * 3 > random.nextInt(101)) {
                        int monsterDamage = monster.getStrength();
                        player.takeDamage(monsterDamage);
                        System.out.println(monster.getName() + " атакует " + player.getName() + " и наносит " + monsterDamage + " урона.");
                    } else {
                        System.out.println(monster.getName() + " промахивается!");
                    }
                }
            }

            executor.shutdown();
        });

        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!player.isAlive()) {
            System.out.println("Вы погибли в бою с " + monster.getName() + ". Игра окончена.");
        } else {
            int experienceReward = monster.getExperienceReward();
            int goldReward = monster.getGoldReward();

            player.gainExperience(experienceReward);
            player.gainGold(goldReward);

            System.out.println("Вы победили " + monster.getName() + " и получили " + experienceReward + " очков опыта и " + goldReward + " золота.");
        }

    }

}