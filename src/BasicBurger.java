public class BasicBurger extends Burger {
    private String rollType;

    BasicBurger(){
        super("Basic",3.56,4);
        this.rollType = "White with Chicken";
    }

    public String getRollType() {
        return rollType;
    }

    public void setRollType(String rollType) {
        this.rollType = rollType;
    }

    @Override
    public String toString() {
        return String.format("%s with %s :- \nCost:  $%.2f \nMax Toppings: %d",
                this.getName(),this.getRollType(),this.getPrice(),this.getMaxToppings());
    }
}
