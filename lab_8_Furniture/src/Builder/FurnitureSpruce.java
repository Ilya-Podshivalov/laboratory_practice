package Builder;

public class FurnitureSpruce {

        private String color;
        private Double length;
        public FurnitureSpruce(String color, Double length){
            this.color = color;
            this.length = length;
        }
        public void Print(){
            System.out.println("Цвет: " + color + ", длина: " + length + "м");
        }

}
