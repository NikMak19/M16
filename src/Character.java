import java.util.Scanner;
import java.util.Random;

public class Character {
    protected String name;
    protected int health;
    protected int strength;
    protected int agility;
    protected int gold;
    protected int experience;

    public Character(String name, int health, int strength, int agility) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
}
    public void attack(Character target) {
        Random random = new Random();
        int damage = this.strength + random.nextInt(6) + 1;
        target.health -= damage;
        System.out.println(this.name + " атакует " + target.name + " и наносит " + damage + " урона.");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getAgility() {
        return 0;
    }

    public int getStrength() {
        return 0;
    }

    public void takeDamage(int playerDamage) {
    }

    public boolean getName() {
        return false;
    }
//        В этой части кода определен базовый класс Character, от которого наследуются классы Player и Monster.
//    Класс Character имеет поля name, health, strength и agility, которые представляют имя, единицы жизни, силу и ловкость персонажа.
//    Конструктор класса Character инициализирует эти поля на основе переданных значений.
//    Метод attack() выполняет атаку на цель и рассчитывает урон на основе силы персонажа и случайного числа от 1 до 6.
//    Метод isAlive() возвращает логическое значение, указывающее, жив ли персонаж (здоровье больше 0).
}
