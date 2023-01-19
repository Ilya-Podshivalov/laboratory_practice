import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.lang.String;
import java.lang.Object;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.*;


public class StringLaba {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String razdel = input.nextLine();
        String P = input.nextLine();
        String[] newStr = new String[Count(str, razdel)];
        int count = 0;
        if (razdel.length() == 1) {
            newStr = str.split(razdel);
            System.out.print("Строка через split: ");
            for (String s : newStr) {
               System.out.print(s + " ");
                count++;
            }
            boolean flag = false;
            System.out.println();
            for (int i = 0; i < count; i++) {
                if (newStr[i].equals(P)) {
                    String s = "%s %s %s %d";
                    System.out.println(String.format(s, "Число ", P, " является лексемой №",(str.indexOf(P) + 1)));
                    flag = true;
                }
            }
            if (!flag) System.out.println("Числа " + P + " среди лексем нет");
        } else {
            System.out.println("Строка через Tokenizer: ");
            StringTokenizer tokenizer = new StringTokenizer(str, razdel);
            for (int i = 0; tokenizer.hasMoreTokens(); i++) {
                newStr[i] = tokenizer.nextToken();
                System.out.print(newStr[i] + " ");
                count++;
            }
            System.out.println();
            boolean flag = false;
            for (int i = 0; i < count; i++) {
                if (newStr[i].equals(P)) {
                    String s = "%s %s %s %d";
                    System.out.println(String.format(s, "Число ", P, " является лексемой №",(str.indexOf(P) + 1)));
                    flag = true;
                }
            }
            if (!flag) System.out.println("Числа " + P + " среди лексем нет");
        }
        str = String.join("", newStr);
        String[] massCount16 = new String[str.length()];
        int count_mass = 0;
        System.out.println();
        char[] charstr = new char[str.length()];
        str.getChars(0, str.length(), charstr, 0);
        System.out.println("Числа из 16 в 10-ой с/c: ");
        for(int i = 0; i < count; i++){
            try {
                int temp = 0;
                temp = Integer.parseInt(newStr[i], 16);

                massCount16[count_mass] = newStr[i];
                count_mass++;
                System.out.println("-> " + temp);
            } catch (NumberFormatException e) {
            }
        }
        System.out.println("Числа 16 с/с, состоящие из больше числа 1, чем 0: ");
        for(int i = 0; i < count_mass; i++){
            int count_0 = 0;
            int count_1 = 0;
            for(int j = 0; j < massCount16[i].length(); j++){
                char ch = massCount16[i].charAt(j);
                if(ch == '0')
                    count_0 += 1;
                else if(ch == '1')
                    count_1 += 1;
            }
            if(count_1 > count_0)
                System.out.print(massCount16[i] + " ");
        }
        System.out.println();
        System.out.print("Числа в 16-ой с/с: ");
        for (int i = 0; i < count_mass; i++) {
            System.out.print(massCount16[i] + " ");
        }
        System.out.println();
        System.out.println("Строка без первого латинского символа: " + str.replaceFirst("([A-z])", ""));             //replace
        System.out.println("Строка без первого числа в 16 c/c: " + str.replaceFirst(massCount16[0], ""));
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(str);
        strBuffer.insert(3, "2022");
        System.out.println("Строка с новым элементом через insert: " + strBuffer);
        strBuffer.delete(3, 7);
        System.out.println("Строка с удаленным элементом через delete: " + strBuffer);
        strBuffer.reverse();
        System.out.println("Перевернутая строка через reverse: " + strBuffer);
        ArrayList<String> strList = new ArrayList<String>();
        for(int i = 0; i < count; i++){
            strList.add(newStr[i]);
        }
        Collections.sort(strList, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        System.out.print("Отсортированная строка через лямды: " + strList);
    }

    public static int Count(String str, String razdel) {
        String[] newStr = new String[str.length()];
        StringTokenizer tokenizer = new StringTokenizer(str, razdel);
        int count = 0;
        for (int i = 0; tokenizer.hasMoreTokens(); i++) {
            newStr[i] = tokenizer.nextToken();
           // System.out.print(newStr[i]);
            count++;
        }
        return count;
    }
}