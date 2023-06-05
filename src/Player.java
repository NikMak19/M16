import java.util.Random;

public class Player extends Character {
    private int level;
    private int healthPotions;

    public Player(String name, int health, int strength, int agility) {
        super(name, health, strength, agility);
        this.level = 1;
        this.experience = 0;
        this.gold = 0;
        this.healthPotions = 3;
    }
    public void heal() {
        if (healthPotions > 0) {
            Random random = new Random();
            int healAmount = random.nextInt(6) + 1;
            this.health += healAmount;
            this.healthPotions--;
            System.out.println(this.name + " восстанавливает здоровье на " + healAmount + " единиц.");
        } else {
            System.out.println("У вас нет зелий для лечения.");
        }
    }
    public void gainExperience(int experience) {
        this.experience += experience;
        System.out.println(this.name + " получает " + experience + " очков опыта.");

        int experienceThreshold = level * 10;

        if (this.experience >= experienceThreshold) {
            levelUp();
        }
        
    }

    private void levelUp() {
        level++;
        System.out.println(this.name + " повышает уровень! Текущий уровень: " + level);

        this.health += 10;
        this.strength += 2;
        this.agility += 1;
        this.healthPotions++;
    }
    public void gainGold(int gold) {
        this.gold += gold;
        System.out.println(this.name + " получает " + gold + " золота.");
    }
    public void showStats() {
        System.out.println("Имя: " + name);
        System.out.println("Уровень: " + level);
        System.out.println("Единицы жизни: " + health);
        System.out.println("Сила: " + strength);
        System.out.println("Ловкость: " + agility);
        System.out.println("Опыт: " + experience);
        System.out.println("Золото: " + gold);
        System.out.println("Зелья здоровья: " + healthPotions);
//            Класс Player наследует класс Character и добавляет дополнительные поля и методы, специфичные для игрока.
//    Поля level, experience, gold и healthPotions представляют уровень, количество опыта, количество золота и количество зелий здоровья соответственно.
//    Конструктор класса Player вызывает конструктор базового класса и инициализирует дополнительные поля значениями по умолчанию.
//    Метод heal() позволяет игроку восстановить здоровье с помощью зелий здоровья. Он случайным образом определяет количество единиц здоровья, которые будут восстановлены, и уменьшает количество доступных зелий здоровья.
//    Метод gainExperience() увеличивает количество опыта игрока и проверяет, достиг ли он порогового значения опыта для повышения уровня. Если достиг, вызывается метод levelUp().
//    Метод levelUp() повышает уровень игрока, увеличивает его характеристики (здоровье, силу, ловкость) и увеличивает количество зелий здоровья.
//    Метод gainGold() увеличивает количество золота игрока.
//    Метод showStats() выводит статистику игрока, включая имя, уровень, единицы жизни, силу, ловкость, опыт, золото и количество зелий здоровья.
    }
}
