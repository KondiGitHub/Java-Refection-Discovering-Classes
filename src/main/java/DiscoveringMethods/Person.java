package DiscoveringMethods;

public class Person {
    private int age;
    private String name;
    private boolean deceased;

    public Person(){}

    public Person(int age, String name, boolean deceased) {
        this.age = age;
        this.name = name;
        this.deceased = deceased;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }
}
