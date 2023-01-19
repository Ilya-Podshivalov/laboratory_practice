import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.io.FileReader;

public class Reg {
    public static void main(String[] args) throws Exception {
        //Scanner input = new Scanner(System.in);
        //String str = input.nextLine();
        FileReader input = new FileReader("input.txt");
        FileWriter output = new FileWriter("output.txt");
        Scanner scanner = new Scanner(input);
        Regula test = new Regula();
        String str;
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            if (test.Check(str)) {
                output.write(str + " - Good\n");
            } else {
                output.write(str + " - no Good\n");
            }
        }
        input.close();
        output.close();
    }
}
