package lesson_1;

public class Main_lesson1 {

    public static void main(String[] args) {
        Human human = new Human("Николай", 2500, 1);
        Cat cat = new Cat("Мурзик", 1500, 2);
        Robot robot = new Robot("Мартин", 500, 3);

        Let let = new Let(1);
        RunningTrack track = new RunningTrack(2000);

        human.info();
        cat.info();
        robot.info();

        robot.run(track.trackDistance);

    }
}
