import balance.BalanceParent;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import category.CategoryParent;
import category.Electronic;
import category.Furniture;
import category.SkinCare;
import discount.AmountBasedDiscount;
import discount.DiscountParent;
import discount.RateBasedDiscount;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {


    public static void createCustomer() {

        Address address1Customer1 = new Address("804", "River Heights Dr", "MJ",
                "Mount Juliet", "TN");

        Address address2Customer1 = new Address("33", "Pallati 4 - Gryka", "Don Bosco",
                "355", "SHQIPERIA");

        Address address1Customer2 = new Address("1600", "Pennsylvania Avenue", "D.C",
                "District Of Columbia", "Maryland");

//======================================================================================================================

        List<Address> customer1AddressList = new ArrayList<>();
        customer1AddressList.add(address1Customer1);
        customer1AddressList.add(address2Customer1);

        List<Address> customer2AddressList = new ArrayList<>();
        customer2AddressList.add(address1Customer2);

//======================================================================================================================

//        Customer [0]
        Customer customer = new Customer("almi2001", "almimeci@gmail.com", "Almi",
                "Meco", customer1AddressList, UUID.randomUUID());

//        Customer [2]
        Customer customer2 = new Customer("ajLOJCE22", "bythkari@gmail.com", "AJ",
                "Xhafari", customer2AddressList, UUID.randomUUID());





        StaticConstants.CUSTOMER_LIST.add(customer);
        StaticConstants.CUSTOMER_LIST.add(customer2);

        //StaticConstants.CUSTOMER_LIST.get(0).setFirstName("Allen");





    }


    public static void createCategory() {

        CategoryParent categoryOneElectronic = new Electronic(UUID.randomUUID(), "PS5"); // using upCASTING
        categoryOneElectronic.generateCategoryCode();

        CategoryParent categoryTwoFurniture = new Furniture(UUID.randomUUID(), "Couch");


        CategoryParent categoryThreeSkinCare = new SkinCare(UUID.randomUUID(), "Facial Cleanser");

        /* Added to List Collection under -> 'StaticConstants' */

        StaticConstants.CATEGORY_LIST.add(categoryOneElectronic);
        StaticConstants.CATEGORY_LIST.add(categoryTwoFurniture);
        StaticConstants.CATEGORY_LIST.add(categoryThreeSkinCare);


    }


    public static void createProduct() {

        Product product1 = new Product("PS5", 650.01, 32, 28, UUID.randomUUID(),
                StaticConstants.CATEGORY_LIST.get(0).getId());

        Product product2 = new Product("Couch",  883.43, 13, 13, UUID.randomUUID(),
                StaticConstants.CATEGORY_LIST.get(1).getId());

        Product product3 = new Product("Facial Cleanser", 8.99, 2004, 1960, UUID.randomUUID(),
                StaticConstants.CATEGORY_LIST.get(2).getId());


        StaticConstants.PRODUCT_LIST.add(product1);
        StaticConstants.PRODUCT_LIST.add(product2);
        StaticConstants.PRODUCT_LIST.add(product3);



    }


    public static void createBalance() {


        BalanceParent customerBalance = new CustomerBalance(StaticConstants.CUSTOMER_LIST.get(0).getUniqueUserId(), 100000.00);
        BalanceParent giftCardBalance = new GiftCardBalance(StaticConstants.CUSTOMER_LIST.get(1).getUniqueUserId(), 10444.00);

        StaticConstants.CUSTOMER_BALANCE_LIST.add(customerBalance);
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(giftCardBalance);




    }


    public static void createDiscount() {

        DiscountParent amountBasedDiscount = new AmountBasedDiscount(UUID.randomUUID(),
                "Spend $250 : Save $25", 250.00, 25.00);

        DiscountParent rateBasedDiscount = new RateBasedDiscount(UUID.randomUUID(),
                "15% off for first time Customers", 1000.00, 15.00);



        StaticConstants.DISCOUNT_LIST.add(amountBasedDiscount);
        StaticConstants.DISCOUNT_LIST.add(rateBasedDiscount);


    }
}
