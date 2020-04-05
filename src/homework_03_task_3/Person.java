package homework_03_task_3;

public class Person implements Human {
    String name;
    String surName;

    @Override
    public void speak() {
        System.out.println(" I am speak. ");
    }
}
