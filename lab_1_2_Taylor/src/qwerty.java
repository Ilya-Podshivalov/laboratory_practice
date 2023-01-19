import java.util.Scanner;
import java.text.*;
import java.math.*;
import java.util.Formatter;

public class qwerty {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();
        Formatter fmtt = new Formatter();
        NumberFormat formatter = NumberFormat.getNumberInstance();
        double x;
        int k;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter k: ");
        k = input.nextInt();
        if (k >= 0) {
            System.out.print("Enter x: ");
            x = input.nextDouble();
            System.out.println(fmt.format("16 k: %#x; 8 k: |%05o|; 16 x: %+a; 10 x: |%5.3f|; %,d", k, k, x, x, 24241242));
            System.out.println(fmtt.format("%3$d, %2$f, %4$d, %1$d", 3229, 32.233, 912, 1));
        } else {
            System.out.println("Error, k < 0.");
        }
    }

    public static class Taylor {
        public static double taylor(double x, int k) {
            double xi = 1, sum = 1, n = 1, e = Math.pow(10, -k);
            while (Math.abs(xi) >= e) {
                n++;
                xi *= (x * x) / ((2 * n - 2) * (2 * n - 3));
                sum += xi;
            }
            System.out.println("Standard value: " + Math.cosh(x));
            System.out.print("Result: ");
            return sum;
        }
    }

    public static class BigTaylor {

        public static BigDecimal bigtaylor(BigDecimal x, BigInteger k) {
            BigDecimal xid = new BigDecimal("1");
            double xi = 1;
            BigDecimal sum = new BigDecimal("1");
            double k1 = k.doubleValue(), e = Math.pow(10, -k1);
            BigDecimal chastd;
            double chast;
            for(int n= 0; xi >= e; n++) {
                chast = (2 * n - 2) * (2 * n - 3);
                chastd = BigDecimal.valueOf(chast);
                xid = xid.multiply(x.multiply(x)).divide(chastd, 10, RoundingMode.CEILING);
                xi = xid.doubleValue();
                sum = sum.add(xid);
            }
            return sum;
        }
    }
}