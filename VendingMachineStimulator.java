import java.util.*;

public class VendingMachineStimulator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("===== VENDING MACHINE SIMULATOR =====");
        System.out.println("1. View Products");
        System.out.println("2. Select Product");
        System.out.println("3. Buy Product");
        System.out.println("4. Add Money");
        System.out.println("5. Check Balance");
        System.out.println("6. Restock Product");
        System.out.println("7. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        VendingMachine machine = new VendingMachine();

        if (choice == 1) {
            machine.displayProducts();
        }
        else if (choice == 2) {
            machine.selectProduct(sc);
        }
        else if (choice == 4) {
            machine.addMoney(sc);
        }
        else if(choice == 3) {
            machine.buyProduct(sc);
        }
        else if (choice == 5) {
            machine.checkBalance();
        }
        else if (choice == 6) {
            System.out.println("Restock the products");
        }
        else if (choice == 7) {
            System.out.println("Thank you!");
        }
        else {
            System.out.println("Invalid choice!");
        }
    }
}

class product {
    int[] productId = {101, 102, 103, 104, 105};

    String[] productName = {
        "Chips", "Chocolate", "Juice", "Biscuits", "Water"
    };

    double[] productPrice = {20, 30, 40, 25, 15};

    int[] stock = {5, 5, 5, 5, 5};
}

class VendingMachine {

    product p1 = new product();
    double balance = 0;

    void displayProducts() {

        System.out.println("----- AVAILABLE PRODUCTS -----");

        for (int i = 0; i < p1.productId.length; i++) {
            System.out.println(
                p1.productId[i] + "  " +
                p1.productName[i] + "  ₹" +
                p1.productPrice[i] + "  Stock: " +
                p1.stock[i]
            );
        }
    }

    void selectProduct(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < p1.productId.length; i++) {

            if (p1.productId[i] == id) {

                System.out.println("Product Name: " + p1.productName[i]);
                System.out.println("Price: ₹" + p1.productPrice[i]);

                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();

                if (quantity <= p1.stock[i]) {
                    System.out.println("Quantity available: " + quantity);
                } else {
                    System.out.println("Insufficient stock!");
                }

                return;
            }
        }

        System.out.println("Product not found!");
    }

    void addMoney(Scanner sc) {

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        balance = balance + amount;

        System.out.println("Money added successfully!");
        System.out.println("Current Balance: ₹" + balance);
    }

    void buyProduct(Scanner sc) {

    System.out.print("Enter Product ID: ");
    int id = sc.nextInt();

    for (int i = 0; i < p1.productId.length; i++) {

        if (p1.productId[i] == id) {

            System.out.println("Product Name: " + p1.productName[i]);
            System.out.println("Price: ₹" + p1.productPrice[i]);

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            if (quantity > p1.stock[i]) {
                System.out.println("Insufficient stock!");
            }
            else {
                double total = p1.productPrice[i] * quantity;

                if (balance >= total) {

                    balance = balance - total;
                    p1.stock[i] = p1.stock[i] - quantity;

                    System.out.println("Purchase successful!");
                    System.out.println("Total Amount: ₹" + total);
                    System.out.println("Remaining Balance: ₹" + balance);
                    System.out.println("Thank You");
                }
                else {
                    System.out.println("Insufficient balance!");
                    System.out.println("Please add ₹" + (total - balance) + " more.");
                }
            }

            return;
        }
    }

    System.out.println("Product not found!");
}

void checkBalance() {
    System.out.println("Current Balance: " + balance);
}
   
}

    

    


        





    




