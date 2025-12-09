package lesson_2;

public class Wolf {
    private String gender;
    private String name;
    private int weight;
    private int age;
    private String color;

    public Wolf() {
    }

    public Wolf(String gender, String name, int weight, int age, String color) {
        this.gender = gender;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
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

    public void howling() {
        System.out.println(name + " воет");
    }

    public void hunting() {
        System.out.println(name + " охотится");
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
        if (age < 0 || age > 8) {
            System.out.println("Некорректный возраст");
            return;
        }
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
