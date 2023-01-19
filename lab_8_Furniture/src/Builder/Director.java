package Builder;

import IFurniture.IBuilder;

public class Director {
    public void createSmallBirch(IBuilder builder){
        builder.setColor("White");
        builder.setLength(2.2);
    }
    public void createBigBirch(IBuilder builder){
        builder.setColor("White");
        builder.setLength(5.4);
    }
}
