package Singleton;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Singleton {
    private static Singleton instance;
    private String nameFile;
    private ArrayList<String> colorList = new ArrayList<String>();
    private ArrayList<Double> lengthList = new ArrayList<Double>();
    protected Singleton(String nameFile) {
        this.nameFile = nameFile;
    }

    public static Singleton getInstance(String nameFile) {
        if (instance == null) {
            instance = new Singleton(nameFile);
        }
        return instance;
    }


    public void getInformation() throws FileNotFoundException {
        File inputFile = new File(nameFile);
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            this.colorList.add(stringTokenizer.nextToken());
            this.lengthList.add(Double.parseDouble(stringTokenizer.nextToken()));
        }
    }

    public void Print() {
        int size = colorList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(colorList.get(i) + " " + lengthList.get(i));
        }
    }
    public String getColor(Integer id){
        if(id > colorList.size())
            return null;
        return colorList.get(id);
    }
    public Double getLength(Integer id){
        if(id > lengthList.size())
            return null;
        return lengthList.get(id);
    }
}