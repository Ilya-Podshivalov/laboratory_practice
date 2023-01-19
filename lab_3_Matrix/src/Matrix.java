import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
import java.lang.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Matrix {
    public static class MemberComparator implements Comparator<Double> {
        public int compare(Double a, Double b) {
            if (a.equals(b)) return 0;
            else if (a < b) return -1;
            else return 1;
        }
    }
    public static class MemberComparator1 implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a.equals(b)) return 0;
            else if (a < b) return -1;
            else return 1;
        }
    }

    public static boolean MatrEquals(Integer[][] mass1, Integer[][] mass2, int n) {
        boolean flag = false;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < n; k++) {
                Integer tmp;
                for (int j1 = k; j1 < n; j1++) {
                    tmp = mass2[k][j1];
                    mass2[k][j1] = mass2[j1][k];
                    mass2[j1][k] = tmp;
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (Arrays.equals(mass1[i], mass2[i])) count++;
            }
            if (count == n) flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getPercentInstance();
        DecimalFormat decimalFormat2 = (DecimalFormat) NumberFormat.getCurrencyInstance();
        MemberComparator comparer = new MemberComparator();
        MemberComparator1 comparer1 = new MemberComparator1();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размерность матрицы: ");
        int n = input.nextInt();
        Double[][] matr = new Double[n][n];
        Integer[][] matr2 = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matr[i][j] =  (Math.random()) * (int) (Math.random() * 10);
            }
        }
        Arrays.sort(matr[n - 1], comparer);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matr2[i][j] = (int) (Math.random() * 100);
            }
        }
        System.out.println("Первая матрица с денежным типом: ");
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(decimalFormat2.format(matr[i][j]) + " ");
            }
        }
        System.out.println();
        System.out.println("Вторая матрица с процентом: ");
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(decimalFormat.format(matr2[i][j]) + " ");
            }
        }
        System.out.println(" ");
        Integer[][] matr3 = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            matr3[i] = Arrays.copyOf(matr2[i], n);
        }
       for (int k = 0; k < n; k++) {
            Integer tmp;
            for (int j1 = k; j1 < n; j1++) {
                tmp = matr2[k][j1];
                matr2[k][j1] = matr2[j1][k];
                matr2[j1][k] = tmp;
            }
        }
        System.out.println(MatrEquals(matr3, matr2, n));
        Arrays.sort(matr2[0], comparer1);
        System.out.println(" ");
        System.out.println("Вторая матрица с отсортированной первой строчкой: ");
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(matr2[i][j] + " ");
            }
        }
        int k;
        System.out.println(" ");
        System.out.println("Введите число для бинарного поиска: ");
        k = input.nextInt();
        if( Arrays.binarySearch(matr2[0], k, comparer1) >= 0) {
            System.out.println("Номер найденного числа:");
            System.out.println(Arrays.binarySearch(matr2[0], k, comparer1) + 1);
        }
        else{
            System.out.println("Число не найдено");
        }
    }
}