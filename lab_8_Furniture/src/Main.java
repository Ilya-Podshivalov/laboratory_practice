import Builder.*;
import Singleton.Singleton;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] argc) throws FileNotFoundException {
        Singleton singleton = Singleton.getInstance("input.txt");
        singleton.getInformation();

        Director director = new Director();
        FurnitureBuilderBirch furnitureBuilderBirch = new FurnitureBuilderBirch();
        director.createBigBirch(furnitureBuilderBirch);
        FurnitureBirch furnitureBirch = furnitureBuilderBirch.getResult();
        furnitureBirch.Print();

        FurnitureBuilderSpruce furnitureBuilderSpruce = new FurnitureBuilderSpruce();
        furnitureBuilderSpruce.setColor(singleton.getColor(1));
        furnitureBuilderSpruce.setLength(singleton.getLength(2));
        FurnitureSpruce furnitureSpruce = furnitureBuilderSpruce.getResult();
        furnitureSpruce.Print();

    }
}
