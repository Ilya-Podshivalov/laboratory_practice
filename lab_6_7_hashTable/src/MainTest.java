import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void searchAddress1() throws FileNotFoundException {
        Hashtable<Integer, PhoneBook> hashtable = new Hashtable<Integer, PhoneBook>();
        ArrayList<PhoneBook> arrayPhoneBook = PhoneBook.readFile("input.txt");
        for (int i = 0; i < arrayPhoneBook.size(); i++) {
            hashtable.put(i + 1, arrayPhoneBook.get(i));
        }
        boolean search = Main.SearchAddress(hashtable, "Rokoso");
        boolean result = true;
        Assert.assertEquals(search, result);
    }

    @Test
    public void searchAddress2() throws FileNotFoundException {
        Hashtable<Integer, PhoneBook> hashtable = new Hashtable<Integer, PhoneBook>();
        ArrayList<PhoneBook> arrayPhoneBook = PhoneBook.readFile("input.txt");
        for (int i = 0; i < arrayPhoneBook.size(); i++) {
            hashtable.put(i + 1, arrayPhoneBook.get(i));
        }
        boolean search = Main.SearchAddress(hashtable, "Rok");
        boolean result = false;
        Assert.assertEquals(search, result);
    }
    @Test
    public void searchFamily1() throws FileNotFoundException {
        Hashtable<Integer, PhoneBook> hashtable = new Hashtable<Integer, PhoneBook>();
        ArrayList<PhoneBook> arrayPhoneBook = PhoneBook.readFile("input.txt");
        for (int i = 0; i < arrayPhoneBook.size(); i++) {
            hashtable.put(i + 1, arrayPhoneBook.get(i));
        }
        boolean search = Main.SearchFamily(hashtable, "Kovalev");
        boolean result = true;
        Assert.assertEquals(search, result);
    }

    @Test
    public void searchFamily2() throws FileNotFoundException {
        Hashtable<Integer, PhoneBook> hashtable = new Hashtable<Integer, PhoneBook>();
        ArrayList<PhoneBook> arrayPhoneBook = PhoneBook.readFile("input.txt");
        for (int i = 0; i < arrayPhoneBook.size(); i++) {
            hashtable.put(i + 1, arrayPhoneBook.get(i));
        }
        boolean search = Main.SearchFamily(hashtable, "Ksaka");
        boolean result = false;
        Assert.assertEquals(search, result);
    }
}