public class HealthyBurger extends Burger{
    private String rollType;

    HealthyBurger(){
        super("Healthy",5.67,6);
        this.rollType = "Brown Rye with Bacon";
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
