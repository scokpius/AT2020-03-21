package homework_01;

import java.util.Scanner;

public class Task01_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeArrya = Integer.parseInt(scan.next());
        int[] arrya = new int[sizeArrya];
        System.out.println("Для заполнения заполнеия массива необходимо, " +
                           "либо в ручную ввести значения, либо введении слово \"automation\"\n");
        String line = scan.next();
        if (line.equals("automation")){
            for (int i = 0; i < arrya.length; i++) {
                arrya[i]= (int) (Math.random()*40)-5;
                System.out.print(arrya[i] + " ");
            }
            System.out.println();
        } else {
            int i=0;
            arrya[i++] = Integer.parseInt(line);
            while (i<sizeArrya){
                int line1=scan.nextInt();
                arrya[i] = line1;
                i++;
            }
        }
        int buffer=arrya[2];
        for (int i = 0; i < arrya.length-2; i++) {
            if (i<2) {
                arrya[i+2] = arrya[i];
//                arrya[i]=0; в случае если первые два элемента должны обнуляться
                arrya[i] = arrya[arrya.length-2+i];
            } else {
                int buffer1 = arrya[i+2];
                arrya[i+2] = buffer;
                buffer=buffer1;
            }
        }
        for (int value : arrya) {
            System.out.print(value + " ");
        }
    }
}
