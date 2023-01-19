package Builder;

public class FurnitureBirch {
    private String color;
    private Double length;
    public FurnitureBirch(String color, Double length){
        this.color = color;
        this.length = length;
    }
    public void Print(){
        System.out.println("Цвет: " + color + ", длина: " + length + "м");
    }
}
