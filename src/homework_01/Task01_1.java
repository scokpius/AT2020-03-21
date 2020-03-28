package homework_01;

public class Task01_1 {
    public static void main(String[] args) {

    /*  преинкремент ++i увелчивает значение на единицу перед взятием значения
        постинкремент i++ увеличивает значение на единицу после взятия значения
     */
        int i = 3;
        if (i++ != ++i) {
            System.out.println("Обяснение верное");
        }
        int a = i++;
        System.out.println("i="+i+" не равно "+"a="+a);
        int b = ++i;
        System.out.println("i="+i+" равно "+"b="+b);
    }
}
