import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private static ArrayList<Burger> burgers = new ArrayList<>();

    Restaurant(){

    }

    public static void displayBurgers(){
        System.out.println("\n\t\t Brampton Burger");
        System.out.println("\t\t ```````````````");
        System.out.println("--------------------------------\n");
        System.out.println("1. " + new BasicBurger());
        System.out.println("--------------------------------");
        System.out.println("2. " + new HealthyBurger());
        System.out.println("--------------------------------");
        System.out.println("3. " + new DeluxeBurger());
        System.out.println("--------------------------------");
    }

    public static int selection(int min, int max, String message){
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.print(message);
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next();
            }
            number = sc.nextInt();
            if (number < min || number > max){
                System.out.println(String.format("%d is not between %d and %d", number, min, max));
            }
        } while (number < min || number > max);
        return number;
    }

    public static void selectBurger(int burgerType){
        switch (burgerType) {
            case 1:
                burgers.add(new BasicBurger());
                break;
            case 2:
                burgers.add(new HealthyBurger());
                break;
            case 3:
                burgers.add(new DeluxeBurger());
                break;
        }
        selectToppings(burgers.get((burgers.size()-1)).getMaxToppings());
    }

    public static void selectToppings(int max){
        int nToppings = 0;
        int opt;

        System.out.println("\nPlease add some toppings:");
        System.out.println("1. " + new Topping("Tomato",0.27));
        System.out.println("2. " + new Topping("Lettuce",0.72));
        System.out.println("3. " + new Topping("Cheese",1.13));
        System.out.println("4. " + new Topping("Carrot",2.75));
        System.out.println("0. That's all");

        do {
            opt = Restaurant.selection(0,4, "Choose any 4 toppings: ");
            switch (opt){
                case 1:
                    burgers.get((burgers.size()-1)).setToppings(new Topping("Tomato",0.27));
                    nToppings++;
                    break;
                case 2:
                    burgers.get((burgers.size()-1)).setToppings(new Topping("Lettuce",0.72));
                    nToppings++;
                    break;
                case 3:
                    burgers.get((burgers.size()-1)).setToppings(new Topping("Cheese",1.13));
                    nToppings++;
                    break;
                case 4:
                    burgers.get((burgers.size()-1)).setToppings(new Topping("Carrot",2.75));
                    nToppings++;
                    break;
                default:
                    break;
            }
        }while (nToppings != max && opt != 0);
    }

    public static double calculateTotal(){
        double total = 0;
        for (Burger b: burgers){
            total += b.priceWithToppings();
        }
        return total;
    }

    public static void printReceipt(){
        double total = calculateTotal();
        System.out.println("\n\t\t Receipt");
        System.out.println("\t\t ```````");
        for (int i=0; i < burgers.size(); i++){
            System.out.println(String.format("%d. %s - %.2f",(i+1),burgers.get(i).getName(),burgers.get(i).getPrice()));
            System.out.println("\nExtras:");
            System.out.println("```````");
            for (int z=0; z < burgers.get(i).getToppings().size(); z++){
                System.out.println((z+1) + ". " + burgers.get(i).getToppings().get(z));
            }
        }
        System.out.println("\n--------------------------------");
        System.out.println(String.format("Amount: %.2f$ + (Tax: %.2f$)", total, (total*0.15)));
        System.out.println("--------------------------------");
        System.out.println(String.format("Amount: %.2f$", (total*1.15)));
        System.out.println("--------------------------------");
    }
}
