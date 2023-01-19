import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static java.lang.Integer.parseInt;


public class Main {
    public static void OutWithLambda(List<Integer> integerList)
    {
        integerList.forEach( (s) -> System.out.print(s + " ") );
    }
    public static boolean SearchFamily(Hashtable<Integer, PhoneBook> hashtable, String search) {
        Enumeration<Integer> numbers = hashtable.keys();
        System.out.println("Поиск по фамилии: ");
        while (numbers.hasMoreElements()) {
            int num = numbers.nextElement();
            if (hashtable.get(num).name.equals(search)) {
                System.out.println("Имя: " + hashtable.get(num).name +
                        " Адрес: " + hashtable.get(num).address +
                        " Телефон: " + hashtable.get(num).number);
                return true;
            }
        }
        System.out.println("Никто не найден.");
        return false;
    }
    public static boolean SearchAddress(Hashtable<Integer, PhoneBook> hashtable, String search) {
        Enumeration<Integer> numbers = hashtable.keys();
        System.out.println("Поиск по адресу: ");
        while (numbers.hasMoreElements()) {
            int num = numbers.nextElement();
            if (hashtable.get(num).address.equals(search)) {
                System.out.println("Имя: " + hashtable.get(num).name +
                        " Адрес: " + hashtable.get(num).address +
                        " Телефон: " + hashtable.get(num).number);
                return true;
            }
        }
        System.out.println("Никто не найден.");
        return false;
    }

    public static void WriteHashtableJSon(Hashtable<Integer, PhoneBook> hashtable, int num) throws IOException {
        JSONArray bookList = new JSONArray();
        JSONObject book = new JSONObject();
        book.put("name", hashtable.get(num).name);
        book.put("address", hashtable.get(num).address);
        book.put("number", hashtable.get(num).number);
        JSONObject bookObject = new JSONObject();
        bookObject.put("book", book);
        bookList.add(bookObject);


        try (FileWriter file = new FileWriter("hashTableOut.json")) {
            file.write(bookList.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Json: " + bookObject);
    }

    public static PhoneBook ReadJson(String nameFile) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(nameFile));
        JSONObject jo = (JSONObject) obj;
        String number = (String) jo.get("number");
        Integer num = parseInt(number);
        String address = (String) jo.get("address");
        String name = (String) jo.get("name");
        PhoneBook phoneBook = new PhoneBook(name, address, num);
        return phoneBook;
    }

    public static void WriteXML(String path, PhoneBook phoneBook) throws IOException, XMLStreamException {
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(path));
        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("name");
        writer.writeCharacters(phoneBook.name);
        writer.writeStartElement("address");
        writer.writeCharacters(phoneBook.address);
        writer.writeStartElement("number");
        writer.writeCharacters(Integer.toString(phoneBook.number));
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
    }
    public static PhoneBook readXML(String path) throws ParserConfigurationException, IOException, SAXException {
        PhoneBook phoneBook = new PhoneBook();
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = docBuilder.parse(path);
        Node root = document.getDocumentElement();
        NodeList segments = root.getChildNodes();
        for (int i = 0; i < segments.getLength(); i++) {
            Node segment = segments.item(i);
            if (segment.getNodeType() != Node.TEXT_NODE) {
                NodeList segmentPoints = segment.getChildNodes();
                for (int j = 0; j < segmentPoints.getLength(); j++) {
                    Node segmentPoint = segmentPoints.item(j);
                    if (segmentPoint.getNodeType() != Node.TEXT_NODE) {
                        String name = segmentPoint.getNodeName();
                        phoneBook.number = Integer.parseInt(segmentPoint.getChildNodes().item(0).getTextContent());
                        if (name.equals("name")) {
                            phoneBook.name = segmentPoint.getChildNodes().item(0).getTextContent().toString();
                        } else if (name.equals("address")){
                            phoneBook.address = (String)segmentPoint.getChildNodes().item(0).getTextContent();
                        }
                    }
                }
            }
        }
        System.out.println(phoneBook.address + phoneBook.name + phoneBook.number);
        return phoneBook;
    }
    public static void JarWriter(String fileToArh, String address) throws IOException {
        JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(address));
        FileInputStream fis = new FileInputStream(fileToArh);
        JarEntry jarEntry = new JarEntry("out.txt");
        jarOutputStream.putNextEntry(jarEntry);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        jarOutputStream.write(buffer);
        fis.close();
        jarOutputStream.close();
    }

    public static void ZIPWriter(String filePath, String address) throws IOException
    {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(address));
        FileInputStream fis = new FileInputStream(filePath);
        ZipEntry zipEntry = new ZipEntry("out.txt");
        zipOutputStream.putNextEntry(zipEntry);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        zipOutputStream.write(buffer);
        fis.close();
        zipOutputStream.close();
    }

    public static void Encryption(String word) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec keySpec = new SecretKeySpec("Bar12345Bar12345".getBytes(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE,keySpec);
        byte[]bytes=cipher.doFinal(word.getBytes());
        for (byte b: bytes)
        {
            System.out.print(b);
        }
        System.out.println();

    }
    public static void main(String[] argc) throws FileNotFoundException, IOException, ParseException, XMLStreamException, ParserConfigurationException, SAXException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
       Hashtable<Integer, PhoneBook> hashtable = new Hashtable<Integer, PhoneBook>();
        ArrayList<PhoneBook> arrayPhoneBook = PhoneBook.readFile("input.txt");
        for (int i = 0; i < arrayPhoneBook.size(); i++) {
            hashtable.put(i + 1, arrayPhoneBook.get(i));
        }
        System.out.println("Поиск по фамилии: ");
        System.out.println();
        hashtable.put(4, ReadJson("hashTableRead.json"));
        Set<Integer> setOfKeys = hashtable.keySet();
        Iterator<Integer> itr = setOfKeys.iterator();
        System.out.println("Все абоненты(итератор): ");
        while(itr.hasNext()){
            int key = itr.next();
            System.out.println("Имя: " + hashtable.get(key).name +
                    " Адрес: " + hashtable.get(key).address +
                    " Телефон: " + hashtable.get(key).number);
        }
        SearchFamily(hashtable, "Semenova");
        SearchAddress(hashtable, "Rokoso");
     //   readXML("inputXML.xml");
        WriteHashtableJSon(hashtable, 2);
        WriteXML("outXML.xml", hashtable.get(1));
        JarWriter("hashTableOut.json", "C://file/archiveR.jar");
        ZIPWriter("outXML.xml", "C://file/archiveZ.zip");
        System.out.print("Шифрование строки: ");
        Encryption("Шифрование строки");
    }
}
