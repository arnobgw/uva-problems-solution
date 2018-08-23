import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        while(reader.hasNext()) {

            long b1 = reader.nextInt();
            long g1 = reader.nextInt();
            long c1 = reader.nextInt();
            long b2 = reader.nextInt();
            long g2 = reader.nextInt();
            long c2 = reader.nextInt();
            long b3 = reader.nextInt();
            long g3 = reader.nextInt();
            long c3 = reader.nextInt();

            long bTemp1 = b1 + b2;
            long gTemp1 = g1 + g2;
            long cTemp1 = c1 + c2;

            long bTemp2 = b2 + b3;
            long gTemp2 = g2 + g3;
            long cTemp2 = c2 + c3;

            long bTemp3 = b1 + b3;
            long gTemp3 = g1 + g3;
            long cTemp3 = c1 + c3;

            long total[] = new long[6];
            long tempTotal[] = new long[6];

            total[0] = bTemp1 + gTemp2 + cTemp3;
            total[1] = bTemp1 + gTemp3 + cTemp2;
            total[2] = bTemp2 + gTemp1 + cTemp3;
            total[3] = bTemp3 + gTemp1 + cTemp2;
            total[4] = bTemp2 + gTemp3 + cTemp1;
            total[5] = bTemp3 + gTemp2 + cTemp1;

            System.arraycopy(total, 0, tempTotal, 0, 6);
            Arrays.sort(tempTotal);

            if (tempTotal[0] == total[2])
                System.out.println("BCG " + tempTotal[0]);
            else if (tempTotal[0] == total[4])
                System.out.println("BGC " + tempTotal[0]);
            else if (tempTotal[0] == total[3])
                System.out.println("CBG " + tempTotal[0]);
            else if (tempTotal[0] == total[1])
                System.out.println("CGB " + tempTotal[0]);
            else if (tempTotal[0] == total[5])
                System.out.println("GBC " + tempTotal[0]);
            else if (tempTotal[0] == total[0])
                System.out.println("GCB " + tempTotal[0]);
        }
    }
}