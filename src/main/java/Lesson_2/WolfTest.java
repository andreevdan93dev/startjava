package Lesson_2;

public class WolfTest {
    public static void main(String[] args) {
        Wolf bolto = new Wolf("male", "Bolto", 1, 1, "gray");
        Wolf rain = new Wolf();
        rain.setGender("female");
        rain.setName("Rain");
        rain.setWeight(1);
        rain.setAge(1);
        rain.setColor("blue");

        wolfAction(bolto);
        wolfAction(rain);
    }

    private static void wolfAction(Wolf wolf) {
        System.out.println(wolf);
        wolf.walk();
        wolf.sit();
        wolf.run();
        wolf.howling();
        wolf.hunting();
    }


}
