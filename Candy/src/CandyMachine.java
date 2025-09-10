//Candy Machine Program
import java.util.*;
public class CandyMachine
{
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args)
    {
        CashRegister cashRegister = new CashRegister(); //Step 1
        Dispenser candy = new Dispenser(100,50); //Step 2
        Dispenser chips = new Dispenser(100,65); //Step 2
        Dispenser gum = new Dispenser(75,45); //Step 2
        Dispenser cookies = new Dispenser(100,85); //Step 2
        int choice; //variable to hold the selection //Step 3
        showSelection(); //Step 4
        choice = console.nextInt(); //Step 5
        while(choice != 9) //Step 6
        {
            switch(choice) //Step 6a
            {
                case 1: sellProduct(candy, cashRegister);
                    break;
                case 2: sellProduct(chips, cashRegister);
                    break;
                case 3: sellProduct(gum, cashRegister);
                    break;
                case 4: sellProduct(cookies, cashRegister);
                    break;
                case 9: break;
                default: System.out.println("Invalid Selection");
            }//end switch
            showSelection(); //Step 6b
            choice = console.nextInt(); //Step 6c
        }//end while
    }//end main
    public static void showSelection()
    {
        System.out.println("*** Welcome to One Stop Candy Shop ***");
        System.out.println("To select an item, enter ");
        System.out.println("1 for Candy");
        System.out.println("2 for Chips");
        System.out.println("3 for Gum");
        System.out.println("4 for Cookies");
        System.out.println("9 to exit");
    }//end showSelection
    public static void sellProduct(Dispenser product, CashRegister cRegister)
    {
        int price; //variable to hold the product price
        int coinsInserted; //variable to hold the amount entered
        int coinsRequired; //variable to show the extra amount needed
        if(product.getCount() > 0) //Step 1
        {
            price = product.getProductCost(); //Step 1a
            coinsRequired = price; //Step 1b
            coinsInserted = 0; //Step 1c
            // Prompt user to insert coins until they have inserted the exact amount
            while (coinsInserted < price) // Step 1d
            {
                System.out.println("Please deposit " + (price - coinsInserted) + " cents"); // Step 1d.i
                int coins = console.nextInt(); // Get the amount of coins inserted
                if (coins < 0) {
                    System.out.println("Invalid input. Please insert a positive amount.");
                    continue; // Skip to the next iteration if invalid input
                }
                coinsInserted += coins; // Update total coins inserted

                // Check if the inserted amount exceeds the required amount
                if (coinsInserted > price) {
                    System.out.println("You have inserted too much. Please insert the exact amount.");
                    coinsInserted -= coins; // Revert the last addition
                }
            }
            cRegister.acceptAmount(coinsInserted); //Step 1e
            product.makeSale(); //Step 1f
            System.out.println("Collect your item at the "
                    + "bottom and enjoy."); //Step 1g
            System.out.println("Total candies sold: " + Dispenser.getTotal());
        }
        else
            System.out.println("Sorry this item is sold out.");
    }//end sellProduct
}
