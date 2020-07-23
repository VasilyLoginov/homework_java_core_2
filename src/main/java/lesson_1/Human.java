package lesson_1;

public class Human extends ObjectOfMotion{

    public Human(String name, int maxDistance, int maxHeight) {
        super(name, maxDistance, maxHeight);
    }

    @Override
    public void info() {
        System.out.println(name);
        System.out.println("Бегает на дистанцию " + maxDistance + " м.");
        System.out.println("Прыгает на высоту " + maxHeight + " м.");
        System.out.println();
    }

}
