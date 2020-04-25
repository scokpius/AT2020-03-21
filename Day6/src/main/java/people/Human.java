package people;

class Human implements Speakable {
    private int age;

    Human(int age) {
        setAge(age);
        speak();
    }

    private void setAge(int age) {
        this.age = age;
    }


}
