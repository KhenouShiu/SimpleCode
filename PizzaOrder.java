package C1S5_MC;

import java.util.Scanner;
public class PizzaOrder {
    public void displayCustomerDetails(String customerName, String customerEmail, Long customerPhoneNo, String customerAddress) {
        System.out.println("customer name is:" + customerName);
        System.out.println("customer email is:" + customerEmail);
        System.out.println("customer phone no. is" + customerPhoneNo);
        System.out.println("customer address is:" + customerAddress);
    }
    public void displayMenu() {
        System.out.println("Select the items to order");
        System.out.format("%3s%19s", "sl No.", "Item Category");
        System.out.println();
        System.out.println("...............................");
        System.out.format("%3s%15s", "1)", "pizza");
        System.out.println();
        System.out.println("         Price of one Regular Pizza:$9.99");
        System.out.println("         Price of  one Medium pizza:$11.99");
        System.out.println("         Price of Large Pizza:$13.99");
        System.out.format("%3s%21s", "2)", "Garlic Bread");
        System.out.println();
        System.out.println("         Price of one Garlic Bread:5.99");
        System.out.format("%3s%19s", "3)", "Beverages:");
        System.out.println();
        System.out.println("         Price of one Beverages is:$1.99");
        System.out.println("enter 1 for pizza,2 for garlic bread and 3 for beverages");
    }
    public float calculatePrizeOfPizza(int noOfPizza, float priceOfPizza)
    {
        float prizeOfPizza=noOfPizza*priceOfPizza;
        return prizeOfPizza;
    }
    public float calculatePrizeOfGarlicBread(int noOfGarlicBread, float priceOfGarlicBread)
    {
        float prizeOfGarlicBread=noOfGarlicBread * priceOfGarlicBread;
        return prizeOfGarlicBread;
    }
    public float calculatePriceOfBeverages(int noOfBeverages, float priceOfBeverages)
    {
        float prizeOfBeverages=noOfBeverages * priceOfBeverages;
        return prizeOfBeverages;
    }
    public float getPriceOfPizzaBasedOnSize(int size) {
        float prizeOfPizza = 0;
        if (size == 1) {
            prizeOfPizza  = 9.99f;
        } else if (size == 2) {
            prizeOfPizza = 11.99f;
        } else if (size == 3) {
            prizeOfPizza= 13.99f;
        } else {
            System.out.println("invalid size");
        }
        return prizeOfPizza;
    }
    public float getPriceOfGarlicBread()
    {
        return 5.99f;
    }
    public float getPriceOfBeverages()
    {
        return 1.99f;
    }

    public float calculateTotalBill(float TotalPizzaPrice, float totalGarlicBreadPrize, float totalBeveragesPrize) {
        float totalBill= TotalPizzaPrice + totalGarlicBreadPrize + totalBeveragesPrize;
        return totalBill;
    }
    public float calculateDiscountAndReturnBillAmount(float totalBillAmount)
    {
        if (totalBillAmount > 50) {
            float discount = (totalBillAmount * 10) / 100;
            float discountedBill = totalBillAmount -discount;
            return discountedBill;
        } else {
            return totalBillAmount;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter customer name");
        String customerName = scan.next();
        System.out.println("enter customer email");
        String customerEmail = scan.next();
        System.out.println("enter customer phone no");
        Long customerPhoneNo = scan.nextLong();
        System.out.println("enter customer address");
        String customerAddress = scan.next();

        PizzaOrder obj = new PizzaOrder();

        int noOfPizzas = 0;
        int totalNoOfPizzas = 0;
        float prizeOfPizza = 0;
        float totalPizzaPrice = 0;

        float garlicBread = obj.getPriceOfGarlicBread();
        int noOfGarlicBread = 0;
        int totalNoOfGarlicBread = 0;
        float totalGarlicBreadPrize = 0;

        float beverages = obj.getPriceOfBeverages();
        int noOfBeverages = 0;
        int totalNoOfBeverages = 0;
        float totalBeveragesPrice = 0;

        int count = 0;
        int i, num;
        do {
            obj.displayMenu();
            num = scan.nextInt();
            if (num == 1) {
                int sizeOfPizza = 0;
                System.out.println("enter the size of pizza");
                sizeOfPizza = scan.nextInt();
                prizeOfPizza = obj.getPriceOfPizzaBasedOnSize(sizeOfPizza);
                System.out.println("enter the no. of pizzas you want to order");
                noOfPizzas = scan.nextInt();
                totalNoOfPizzas += noOfPizzas;
                totalPizzaPrice += obj.calculatePrizeOfPizza(noOfPizzas, prizeOfPizza);
            } else if (num == 2) {
                System.out.println("enter the no. of garlic bread you want to order");
                noOfGarlicBread = scan.nextInt();
                totalNoOfGarlicBread += noOfGarlicBread;
                totalGarlicBreadPrize += obj.calculatePrizeOfGarlicBread(noOfGarlicBread, garlicBread);
            } else if (num == 3) {
                System.out.println("enter the no. of beverages you want to order");
                noOfBeverages = scan.nextInt();
                totalNoOfBeverages += noOfBeverages;
                totalBeveragesPrice += obj.calculatePrizeOfGarlicBread(noOfGarlicBread, beverages);
            }
            System.out.println("enter 1 to continue and 0 to exit");
            count = scan.nextInt();
            if (count == 0) {
                System.out.println("thank you for your order");
            }
            i = num;
            num++;
        } while (count > 0);
        float totalBill=0;
        totalBill = obj.calculateTotalBill(totalPizzaPrice, totalGarlicBreadPrize, totalBeveragesPrice);
        System.out.println("customer details");
        System.out.println("......................");
        obj.displayCustomerDetails(customerName, customerEmail, customerPhoneNo, customerAddress);
        System.out.println("......................");
        System.out.println("order details");
        System.out.println("............................................................................");
        System.out.println("the no of pizza order             :" + totalNoOfPizzas);
        System.out.println("the no of garlic bread ordered    :" + totalNoOfGarlicBread);
        System.out.println("the no of beverages ordered       :" + totalNoOfBeverages);
        System.out.println(".............................................................................");
        System.out.println("the total bill amount is          :" + totalBill);
        System.out.println("the total bill after discount is  :"+obj.calculateDiscountAndReturnBillAmount(totalBill));
        System.out.println("...............................................................................");
        System.out.println("your total pizza prize is         :" + totalPizzaPrice);
        System.out.println("your total garlic bread prize is  :" + totalGarlicBreadPrize);
        System.out.println("your total beverages prize is     :" + totalBeveragesPrice);
    }
}

