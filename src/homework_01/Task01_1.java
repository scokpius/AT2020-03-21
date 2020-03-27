package homework_01;

public class Task01_1 {
    public static void main(String[] args) {

    /*  преинкремент ++i увелчивает значение на единицу перед взятием значения
        постинкремент i++ увеличивает значение на единицу после взятия значения
     */
        int i = 3;
        int a = ++i;
        int b = i++;
        if (++i != i++) {
            System.out.println("yes");
        }
    }
}
