package homework_01;

import java.util.Scanner;

public class Task01_4 {
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
        int size=arrya.length;
        if (sizeArrya%2!=0) {size = arrya.length-1;}
        int buffer;
        for (int i = 0; i < size-1; i=i+2) {
            buffer=arrya[i];
            arrya[i]=arrya[i+1];
            arrya[i+1]=buffer;
        }
        for (int value : arrya) {
            System.out.print(value + " ");
        }
    }
}
