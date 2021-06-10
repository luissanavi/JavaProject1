public class App {
    public static void main(String[] args) {
        Restaurant.displayBurgers();
        Restaurant.selectBurger(Restaurant.selection(1,3,"Select: "));
        Restaurant.printReceipt();
    }
}