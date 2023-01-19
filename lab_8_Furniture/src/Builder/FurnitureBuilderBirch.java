package Builder;

import IFurniture.IBuilder;
public class FurnitureBuilderBirch implements IBuilder {
    private String color;
    private Double length;
    public void setColor(String color){
        this.color = color;
    }
    public void setLength(Double length){
        this.length = length;
    }
    public FurnitureBirch getResult(){
        return new FurnitureBirch(color, length);
    }

}
