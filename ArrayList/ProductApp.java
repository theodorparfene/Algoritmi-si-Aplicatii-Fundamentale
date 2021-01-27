import java.util.ArrayList;
import java.util.Scanner;

public class ProductApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> listOfProducts = new ArrayList<>();
        boolean running = true;

        while(running) {
            System.out.println("\nPlease select an option:" +
                                "\n1. Add a product" +
                                "\n2. Display list of products" +
                                "\n3. Replace a product" +
                                "\n4. Remove a product" +
                                "\n5. Display list size" +
                                "\n6. Clear all products from list" +
                                "\nPress any other key to quit");
            int answer = sc.nextInt();
            switch (answer) {
                case 1:
                    System.out.println("Please choose a name for your product:");
                        String nameOfProduct = sc.next();
                    System.out.println("Would you like to set your product at the beginning of the list? (selecting any key other than 1 will put it at the end of the list)");
                    int addAns = sc.nextInt();
                    if (addAns == 1) {
                        Product product = new Product(nameOfProduct);
                        listOfProducts.add(0, product);
                        break;
                    } else {
                        Product product = new Product(nameOfProduct);
                        listOfProducts.add(product);
                        break;
                    }
                case 2:
                    System.out.print("List of products: ");
                    for (Product product : listOfProducts) {
                        System.out.print(product.getName() + " ");
                    }
                    break;
                case 3:
                    System.out.println("Please choose another product:");
                    nameOfProduct = sc.next();
                    Product product = new Product(nameOfProduct);
                    System.out.println("Please choose the index of the product you wish to replace:");
                    for (int i = 0; i < listOfProducts.size(); i++) {
                        System.out.println(i + "." + listOfProducts.get(i).getName());
                    }
                    int replaceAns = sc.nextInt();
                    listOfProducts.set(replaceAns, product);
                    break;
                case 4:
                    System.out.println("Please choose the index of the product you wish to remove:");
                    for (int i = 0; i < listOfProducts.size(); i++) {
                        System.out.println(i + "." + listOfProducts.get(i).getName());
                    }
                    int removeAns = sc.nextInt();
                    listOfProducts.remove(removeAns);
                    break;
                case 5:
                    System.out.println("Size of this list: " + listOfProducts.size());
                case 6:
                    System.out.println("Do you wish to clear all products from this list? 1/2");
                    int clearAns = sc.nextInt();
                    if (clearAns == 1) {
                        listOfProducts.clear();
                        break;
                    } else if (clearAns == 2) {
                        break;
                    }
                default:
                    running = false;
                    break;
            }
        }

        sc.close();

    }
}
