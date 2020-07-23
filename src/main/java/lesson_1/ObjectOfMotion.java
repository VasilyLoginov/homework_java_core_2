package lesson_1;

public class ObjectOfMotion {

    protected String objectType;
    protected String name;
    protected int maxDistance;
    protected int maxHeight;
    protected boolean isRun = false;
    protected boolean isJump = false;

    public ObjectOfMotion(String name, int maxDistance, int maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    public void info(){
        System.out.println(objectType + " " + name);
        System.out.println("Бегает на дистанцию " + maxDistance + " м.");
        System.out.println("Прыгает на высоту " + maxHeight + " м.");
        System.out.println();
    }

    public void run(int distance){
        if(distance > maxDistance){
            System.out.println(objectType + " " +name);
            System.out.println("Не может пробежать " + distance + " м.");
            isRun = false;
            return;
        }
        System.out.println("Выполнено!");
        isRun = true;
    }

    public void jump(int height){
        if(height > maxHeight){
            System.out.println(objectType + " " +name);
            System.out.println("Не может прыгнуть на высоту " + height + " м.");
            isJump = false;
            return;
        }
        System.out.println("Выполнено!");
        isJump = true;
    }


}
