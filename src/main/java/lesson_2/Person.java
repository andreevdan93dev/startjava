package lesson_2;

public class Person {
    private String gender;
    private String name;
    private int height;
    private int weight;
    private int age;


    public Person(String gender, String name, int height, int weight, int age) {
        this.gender = gender;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public void walk() {
        System.out.println(name + " идет");
    }

    public void sit() {
        System.out.println(name + " сидит");
    }

    public void run() {
        System.out.println(name + " бежит");
    }

    public void talk() {
        System.out.println(name + " говорит");
    }

    public void learnJava() {
        System.out.println(name + " учит джаву");
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
