package people;

public class Person extends Human {
    private String name;
    private String surName;

    public Person(int age, String name, String surName) {
        super(age);
        setName(name);
        setSurName(surName);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSurName(String surName) {
        this.surName = surName;
    }

}
