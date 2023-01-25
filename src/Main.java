import balance.BalanceParent;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import category.CategoryParent;
import discount.DiscountParent;

import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {


        DataGenerator.createCustomer();
        DataGenerator.createCategory();
        DataGenerator.createProduct();
        DataGenerator.createBalance();
        DataGenerator.createDiscount();


        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("");
        System.out.println("Select Customer");

        for (int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); i++) {

            System.out.println("Type " + i + " to chose this Customer: " + StaticConstants.CUSTOMER_LIST.get(i).getFirstName());

        }

        /* The input (via scanner) is used to call the object of {CUSTOMER_LIST} via index #  */

        Customer customer = StaticConstants.CUSTOMER_LIST.get(input.nextInt());


        Cart cart = new Cart(customer);

        boolean exitFeature = true;

        while (exitFeature == true) { // infinite loop

            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.println("");
            System.out.println("Select Menu # : 0 - 9");

            for (int i = 0; i < menuOptions().length; i++) {
                System.out.println(i + " - " + menuOptions()[i]);
            }

            int menuSelection = input.nextInt();


            switch (menuSelection) {
                case 0: // List Categories
                    for (CategoryParent category : StaticConstants.CATEGORY_LIST) {
                        System.out.println("Category Name: " + category.getClass().getSimpleName());
                        System.out.println("Category #: " + category.generateCategoryCode());
                        System.out.println("------------------------------------------------");
                    }
                    break;
                case 1: // List Products
                    for (Product product : StaticConstants.PRODUCT_LIST) {
                        System.out.println("Product Name: " + product.getName());
                        System.out.println("Product Price: $" + product.getPrice());
                        System.out.println("Category ID: " + product.getCategoryID());
                        System.out.println("Product ID: " + product.getId());
                        System.out.println("------------------------------------------------");
                    }
                    break;
                case 2: // List Discounts
                    for (DiscountParent discount : StaticConstants.DISCOUNT_LIST) {
                        System.out.println("Discount: " + discount.getDiscountName());
                        System.out.println("------------------------------------------------");
                    }
                    break;
                case 3: // See Balance
                    CustomerBalance cBalance = findCustomerBalance(customer.getUniqueUserId());
                    GiftCardBalance gBalance = findGiftCardBalance(customer.getUniqueUserId());
                    double totalBalance = cBalance.getBalance() + gBalance.getBalance();
                    System.out.println("Total Balance: " + totalBalance);
                    System.out.println("Customer Balance: " + cBalance.getBalance());
                    System.out.println("Gift Card Balance: " + gBalance.getBalance());
                    break;
                case 4: // Add Balance
                    CustomerBalance customerBalance = findCustomerBalance(customer.getUniqueUserId());
                    GiftCardBalance gifCardBalance = findGiftCardBalance(customer.getUniqueUserId());
                    System.out.println("Which Account would you like to add?");
                    System.out.println("Type 1 for Customer Balance : Current Balance --> " + customerBalance.getBalance());
                    System.out.println("Type 2 for Gift Card Balance : Current Balance --> " + gifCardBalance.getBalance());
                    int balanceAccountSelection = input.nextInt();
                    System.out.println("How much money ($) would you like to add?");
                    double amountAdded = input.nextInt();

                    switch (balanceAccountSelection) {
                        case 1:
                            customerBalance.addBalance(amountAdded);
                            System.out.println("Customer Account #" + customerBalance.getCustomerID());
                            System.out.println("New Customer Balance: " + customerBalance.getBalance());
                            break;
                        case 2:
                            gifCardBalance.addBalance(amountAdded);
                            System.out.println("Customer Account #" + gifCardBalance.getCustomerID());
                            System.out.println("New Gift Card Balance: " + gifCardBalance.getBalance());
                            break;
                    }

                    break;
                case 5: // Place Order
                    Map<Product, Integer> map = new HashMap<>();
                    cart.setProductMap(map);

                    while (true) {
                        System.out.println("Which Product would you like to add to Cart?");
                        System.out.println("To Exit : Type 'EXIT' ");

                        for (Product product : StaticConstants.PRODUCT_LIST) {
                            System.out.println(product.getName() + " costs : $" + product.getPrice());
                            System.out.println("Total Remaining Stock: " + product.getRemainingStock());
                            System.out.println("Expected Delivery: " + product.getDeliveryDueDate());
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        }

                        String productID = input.next();

                        Product product = findProductWithID(productID);
                        if (!totalStockAvailable(cart, product)) {
                            System.out.println("Stock is Insufficient : Please Select New Amount");
                            continue;
                        }

                        System.out.println("Would you like too add more items to the cart?");
                        System.out.println("Type (Y) for yes ; (N) for no");

                        String choice = input.next();
                        if (!choice.equalsIgnoreCase("y")) {
                            break;
                        }

                        System.out.println("Apply any discounts if eligible");

                        for (DiscountParent discount : StaticConstants.DISCOUNT_LIST) {
                            System.out.println("Discount :" + discount.getDiscountName());
                        }

                        String discountID = input.next();

                        if (!discountID.equals("no")) {
                            System.exit(1);
                        } else {
                            System.out.println("Discount Applied: ");
                        }

                    }

                    break;
                case 6: // See Cart

                    System.out.println("Current Cart");
                    cart.calculateCartTotal();

                    break;
                case 7: // See Order Details
                    break;
                case 8: // Current Address
                    if (StaticConstants.CUSTOMER_LIST.get(0).getFirstName().equals(customer.getFirstName())) {
                        System.out.println("Customer: " + customer.getFirstName() + "'s current address:");
                        System.out.println(customer.getAddress().get(0).getStreetNumber() + " " + customer.getAddress().get(0).getStreetName());
                        System.out.println(customer.getAddress().get(0).getZipCode() + ", " + customer.getAddress().get(0).getState());

                    } else if (StaticConstants.CUSTOMER_LIST.get(1).getFirstName().equals(customer.getFirstName())) {
                        System.out.println("Customer: " + customer.getFirstName() + "'s current address:");
                        System.out.println(StaticConstants.CUSTOMER_LIST.get(1).getAddress().get(0).getStreetNumber() +
                                " " + StaticConstants.CUSTOMER_LIST.get(1).getAddress().get(0).getStreetName());
                        System.out.println(StaticConstants.CUSTOMER_LIST.get(1).getAddress().get(0).getZipCode() +
                                ", " + StaticConstants.CUSTOMER_LIST.get(1).getAddress().get(0).getState());

                    }
                    break;
                case 9: // Exit
                    System.err.println("Application Closed");
                    exitFeature = false;


            }

        }


        input.close();
    }

    private static boolean totalStockAvailable(Cart cart, Product product) {
        System.out.println("Please Provide Product Count:");

        Scanner input = new Scanner(System.in);
        int count = input.nextInt();


        Integer cartAmount = cart.getProductMap().get(product);

        if (cartAmount != null && product.getRemainingStock() > cartAmount + count) {
            cart.getProductMap().put(product, cartAmount + count);
            return true;

        } else if (product.getRemainingStock() > count) {
            cart.getProductMap().put(product, count);
            return true;
        }
        return false;

    }

    private static Product findProductWithID(String productID) throws Exception {
        for (Product product : StaticConstants.PRODUCT_LIST) {
            if (product.getId().toString().equals(productID)) {
                return product;
            }
        }


        throw new Exception("Product Not Found");
    }


    private static CustomerBalance findCustomerBalance(UUID customerID) {
        for (BalanceParent customerBalance : StaticConstants.CUSTOMER_BALANCE_LIST) {
            if (customerBalance.getCustomerID().toString().equals(customerID.toString())) {
                return (CustomerBalance) customerBalance;
            }
        }
        CustomerBalance customerBalance = new CustomerBalance(customerID, 0d);

        StaticConstants.CUSTOMER_BALANCE_LIST.add(customerBalance);

        return customerBalance;
    }


    private static GiftCardBalance findGiftCardBalance(UUID customerID) {
        for (BalanceParent giftCardBalance : StaticConstants.GIFT_CARD_BALANCE_LIST) {
            if (giftCardBalance.getCustomerID().toString().equals(customerID.toString())) {
                return (GiftCardBalance) giftCardBalance;
            }
        }

        GiftCardBalance giftCardBalance = new GiftCardBalance(customerID, 0d);
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(giftCardBalance);

        return giftCardBalance;
    }


    private static String[] menuOptions() {

        return new String[]{"List Categories", "List Products", "List Discounts", "See Balance", "Add Balance",
                "Place Order", "See Cart", "See Order Details", "Current Address", "Close App"};

    }

}
