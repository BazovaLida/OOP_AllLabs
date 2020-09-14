import java.util.Scanner;

public class LabOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter numbers for sum. n = ");
        if (in.hasNextInt()) {
            int n = in.nextInt();
            System.out.println("m = ");
            if (in.hasNextInt()) {
                int m = in.nextInt();
                System.out.println("a = ");
                if (in.hasNextInt()) {
                    int a = in.nextInt();
                    System.out.println("b = ");
                    if (in.hasNextInt()) {
                        int b = in.nextInt();
                        float S = 0;

                        if ((a <= -1 && n >= -1) || (b <= 0 && m >= 0) || a > n || b > m) {
                            System.out.println("Entered value are not for this formula");
                        } else {
                            for (int i = a; i <= n; i++) {
                                for (int j = b; j <= m; j++) {
                                    S += ((float) i / j) / (i + 1);
                                }
                            } System.out.println("S=" + S);
                        }
                    }
                }
            }
        } in.close();
        System.out.println("Done! (or you enter something strange)");
    }
}
