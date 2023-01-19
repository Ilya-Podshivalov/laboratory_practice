package Builder;

import IFurniture.IBuilder;
public class FurnitureBuilderSpruce implements IBuilder {
    private String color;
    private Double length;
    public void setColor(String color){
        this.color = color;
    }
    public void setLength(Double length){
        this.length = length;
    }
    public FurnitureSpruce getResult(){
        return new FurnitureSpruce(color, length);
    }

}
