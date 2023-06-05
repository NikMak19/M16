
public class Monster extends Character {
    private int experienceReward;
    private int goldReward;
    public Monster(String name, int health1, int i, int health, int strength, int agility) {
        super(name, health, strength, agility);
        this.experienceReward = experienceReward;
        this.goldReward = goldReward;
    }
    public int getExperienceReward() {
        return experienceReward;
    }
    public int getGoldReward() {
        return goldReward;
    }
//        Класс Monster также наследует класс Character и добавляет дополнительные поля experienceReward и goldReward, которые представляют количество опыта и золота, которые игрок получает при победе над монстром.
//    Конструктор класса Monster вызывает конструктор базового класса и инициализирует дополнительные поля значениями, переданными при создании монстра.
//    Методы getExperienceReward() и getGoldReward() возвращают количество опыта и золота, соответственно, за победу над монстром.
}
