public class DeluxeBurger extends Burger{
    private String rollType;

    DeluxeBurger(){
        super("Deluxe",14.54,2);
        this.rollType = "White with Sousage";
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
