import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int n;
        int eachCycleLength;

        while (reader.hasNextInt())
        {
            int ii = reader.nextInt();
            int jj = reader.nextInt();
            int i = ii;
            int j = jj;

            if (i>j)
            {
                j=ii;
                i=jj;
            }

            int maximumCycleLength = 0;

            for (int x = i; x <= j; x++) {
                n = x;
                eachCycleLength = 1;
                while (n != 1) {

                    if ((n % 2) != 0)
                        n = 3 * n + 1;
                    else
                        n = n / 2;

                    eachCycleLength++;
                }
                if (eachCycleLength > maximumCycleLength)
                    maximumCycleLength = eachCycleLength;
            }
            System.out.println(ii + " " + jj + " " + maximumCycleLength);
        }
    }
}
