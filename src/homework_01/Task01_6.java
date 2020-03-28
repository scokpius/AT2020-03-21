package homework_01;

import java.util.*;
import java.util.stream.IntStream;


public class Task01_6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeArrya = Integer.parseInt(scan.next());
        int[] array = new int[sizeArrya];
        System.out.println("Для заполнения заполнеия массива необходимо, " +
                           "либо в ручную ввести значения, либо введении слово \"automation\"\n");
        String line = scan.next();
        if (line.equals("automation")){
            for (int i = 0; i < array.length; i++) {
                array[i]= (int) (Math.random()*40);
                System.out.print(array[i] + " ");
            }
            System.out.println();
        } else {
            int i=0;
            array[i++] = Integer.parseInt(line);
            while (i<sizeArrya){
                int line1=scan.nextInt();
                array[i] = line1;
                i++;
            }
        }
        List<Integer> list = new ArrayList<>();
// Stream<Integer> stream = (Stream<Integer>) Arrays.stream(array); не дает воспользаватьс прсит преведение типов
        IntStream stream = Arrays.stream(array);
        stream.forEach(str->{if (str%2==0)  list.add(str);});
        list.sort(Comparator.comparing(Integer::intValue));
        list.forEach(ls -> {if ((ls>10)&(ls<=20)) System.out.print(ls + " ");});
    }
}
