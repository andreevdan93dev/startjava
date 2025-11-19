package Lesson_2;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf("male", "Bolto", 1, 1, "gray");
        System.out.println(wolf);
        wolf.walk();
        wolf.sit();
        wolf.run();
        wolf.howling();
        wolf.hunting();
    }


}
