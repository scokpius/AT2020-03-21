package people;

public interface Speakable {
    default void speak(){
        System.out.println(String.format("Hi, it is %s spiking.", this.getClass().getSimpleName()));
    }
}
