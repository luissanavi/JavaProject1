public class Topping {

    private String name;
    private Double price;

    Topping(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s : $%.2f", this.name, this.price);
    }
}
