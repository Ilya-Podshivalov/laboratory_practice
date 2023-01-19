import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
//import org.json.simple.JSONObject;
public class PhoneBook {
   public String name;
   public String address;
   public int number;
   PhoneBook(){}
    public PhoneBook(String name, String address, int number){
       this.name = name;
       this.address = address;
       this.number = number;
    }
   public static PhoneBook getInformation(String str){
       PhoneBook phoneBook = new PhoneBook();
       StringTokenizer stringTokenizer = new StringTokenizer(str);
       phoneBook.name = stringTokenizer.nextToken();
       phoneBook.address = stringTokenizer.nextToken();
       phoneBook.number = Integer.parseInt(stringTokenizer.nextToken());
       return phoneBook;
   }
   public static ArrayList<PhoneBook> readFile(String nameFile) throws FileNotFoundException {
       File inputFile = new File(nameFile);
       Scanner scanner = new Scanner(inputFile);
       int size = Integer.parseInt(scanner.nextLine());
       ArrayList<PhoneBook> phoneBookList = new ArrayList<PhoneBook>(size);
       for(int i = 0; i < size; i++){
           String str = scanner.nextLine();
           phoneBookList.add(getInformation(str));
       }
       return phoneBookList;
   }

   public int getNumber(){
       return number;
   }
   @Override
   public int hashCode(){
       return this.getNumber();
   }
    public boolean equals(Object o)
    {
        if (o instanceof PhoneBook) {
            return (this.number) == (((PhoneBook)o).number);
        }
        return false;
    }

}
