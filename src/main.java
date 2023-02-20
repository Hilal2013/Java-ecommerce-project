import balance.Balance;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import category.Category;
import customer.Customer;
import discount.Discount;

import java.util.*;

public class main {
    public static void main(String[] args) {
        //createCustomer();we should import we should call through classname
        DataGenerator.createCustomer();
        DataGenerator.createCategory();
        DataGenerator.createProduct();
        DataGenerator.createBalance();
        DataGenerator.createDiscount();
        //to confirm address
        printAddressByCustomerId(StaticConstants.CUSTOMER_LIST.get(0));
        //Address{StreetNumber='7925', StreetName='Jones Branch Dr', ZipCode='22102', State='VA'}
        //Address{StreetNumber='825', StreetName='GeorgeTown Pky', ZipCode='22036', State='VA'}
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Customer");
        for (int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); i++) {
            System.out.println("Type " + i + " for customer: " + StaticConstants.CUSTOMER_LIST.get(i).getUserName());
        }
//I need to capture object
        Customer customer = StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());
        //right now customer logged in system
        //example on amazon you add products on card//you are done no
        // whenever you loged out your application is done//
        Cart cart = new Cart(customer);//I create empty card
        while (true) {
            System.out.println("What would you like to do? just type id for selection");
            for (int i = 0; i < prepareMenuOptions().length; i++) {
                System.out.println(i + "-" + prepareMenuOptions()[i]);
            }
            int menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 0://list categories
                    for (Category category : StaticConstants.CATEGORY_LIST) {
                        System.out.println("Category Code " + category.generateCategoryCode() + " category name: " + category.getName());
                    }
                    break;
                case 1: //list products  //product name, product category name
                    try {
                        for (Product product : StaticConstants.PRODUCT_LIST) {
                            System.out.println("Product Name:" + product.getName() + "Product Category Name:" + product.getCategoryName());
                        }
                    } catch (Exception e) {
                        //getMessage()comes throws from Product class(getProductCategoryName())//my getmessage is holding
                        // throw new Exception("Category not found," + getName());
                        System.out.println("Product could not printed because category not found for product name:" + e.getMessage().split(",")[1]);

                    }
                    break;

                case 2://list discounts
                    for (Discount discount : StaticConstants.DISCOUNT_LIST) {
                        System.out.println("Discount Name: " + discount.getName() + " Discount threshold amount: " + discount.getThresholdAmount());
                    }
                    break;
                case 3:
                    //create findCustomerBalance()
                    CustomerBalance cBalance = findCustomerBalance(customer.getId());
                    //I wanna see the gift card balance as well
                    GiftCardBalance gBalance = findGiftCardBalance(customer.getId());
                    double totalBalance = cBalance.getBalance() + gBalance.getBalance();
                    System.out.println("Total Balance: " + totalBalance);
                    System.out.println("Customer Balance: " + cBalance.getBalance());
                    System.out.println("Gift Card Balance: " + gBalance.getBalance());
                    break;
                case 4:
                    //I will add some money on it but first get customerbalance
                    CustomerBalance customerBalance = findCustomerBalance(customer.getId());
                    GiftCardBalance giftCardBalance = findGiftCardBalance(customer.getId());
                    System.out.println("Which account would you like to add?");
                    System.out.println("Type 1 for Customer Balance: " + customerBalance.getBalance());
                    System.out.println("Type 2 for Gift Card Balance: " + giftCardBalance.getBalance());
                    int balanceAccountSelection = scanner.nextInt();
                    System.out.println("How much you would like to add?");
                    double additionalAmount = scanner.nextDouble();
                    switch (balanceAccountSelection) {
                        case 1:
                            customerBalance.addBalance(additionalAmount);
                            System.out.println("New customer Balance: " + customerBalance.getBalance());
                            break;
                        case 2:
                            giftCardBalance.addBalance(additionalAmount);
                            System.out.println("New Gift Card Balance: " + giftCardBalance.getBalance());
                            break;
                    }
                    break;
                case 5:
                    Map<Product, Integer> map = new HashMap<>();
                    cart.setProductMap(map);
                    while (true) {
                        //to keep adding products in my cart
                        System.out.println("Which product you want to add to your cart.For exit product selection Type: exit");
                        //if customer wants keep adding I need to show the products
                        for (Product product : StaticConstants.PRODUCT_LIST) {
                            try {
                                System.out.println("id: " + product.getId() + "price: " + product.getPrice() +
                                        "Product Category: " + product.getCategoryName() +
                                        "Stock: " + product.getRemainingStock() +
                                        "Product Delivery Due: " + product.getDeliveryDueDate());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        String productId = scanner.next();
                        try {
                            Product product = findProductById(productId);
                            if (!putItemToCartIfStockAvailable(cart, product)) {
                                System.out.println("Stock is insufficient. Please try again");
                                continue;
                                //it needs to getting to loop again
                            }

                        } catch (Exception e) {
                            System.out.println("Product does not exist.Please try again");
                            continue;
                        }
//lets say customer added product
                        System.out.println("Do you want to add more product. Type Y for adding more, N for existing");
                        String decision = scanner.next();
                        if (!decision.equals("Y")) {
                            break;
                        }
                        System.out.println("seems there are discount options. Do you want to see and apply to your cart if it is applicable. For no discount type no");
                        for (Discount discount : StaticConstants.DISCOUNT_LIST) {
                            System.out.println("Discount id: " + discount.getId() + " Discount name: " + discount.getName());
                            String discountId = scanner.next();
                            if (!discountId.equals("no")){
                                try {
                                    Discount discount1 = findDiscountById(discountId);
//                                    if (discount.decideDiscountIsApplicableToCart(Cart cart)) {
//                                        cart.setDiscountId(discount.getId());
//                                    }

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                            }


                        }
                    }
                    break;
                case 6:
                    break;
                case 7:
                    break;

                case 8:
                    break;
                case 9:
                    break;

            }

        }

    }

    private static Discount findDiscountById(String discountId) throws Exception {
        for(Discount discount: StaticConstants.DISCOUNT_LIST){
            if(discount.getId().toString().equals(discountId)){
                return discount;
            }
        }
        throw new Exception("Discount couldn't applied because couldn't found");
    }

    private static boolean putItemToCartIfStockAvailable(Cart cart, Product product) {
        System.out.println("Please provide product count:");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        //if you have already    items in yoour cart. how many existing product in your card?I should know

        Integer cartCount = cart.getProductMap().get(product);

        if (cartCount != 0 && product.getRemainingStock() > cartCount + count) {//something in the cart
            cart.getProductMap().put(product, cartCount + count);
            return true;
        } else if (product.getRemainingStock() >= count) {
            cart.getProductMap().put(product, count);
            return true;
        }
        return false;
    }

    private static Product findProductById(String productId) throws Exception {
        for (Product product : StaticConstants.PRODUCT_LIST) {

            if (product.getId().toString().equals(productId)) {
                return product;
            }
        }
        throw new Exception("Product not found");
    }

    //im gonna build this method here and only usage of method is here
    //in the main // no other classes will have access to this method//so private
    //static cannot call nonstatic
    private static String[] prepareMenuOptions() {
        //Im creating menu items

        return new String[]{"List Categories", "List Products", "List Discount", "See Balance", "Add Balance",
                "Place an Order", "See Cart", "See Order Details", "See Your Address", "Close App"};
    }

    private static CustomerBalance findCustomerBalance(UUID customerId) {
/*
  return      StaticConstants.CUSTOMER_BALANCE_LIST.stream()
                .map(Balance::getCustomerId)
                .filter(each->each.toString().equals(customerId.toString()))


 */

        for (Balance customerBalance : StaticConstants.CUSTOMER_BALANCE_LIST) {
            if (customerBalance.getCustomerId().toString().equals(customerId.toString())) {
                return (CustomerBalance) customerBalance;
            }
        }
//if customer doesnt have any balance assigned as a zero
        CustomerBalance customerBalance = new CustomerBalance(customerId, 0d);//itisnot inthe database it is now in cloud
        StaticConstants.CUSTOMER_BALANCE_LIST.add(customerBalance);
        return customerBalance;



    }

    private static GiftCardBalance findGiftCardBalance(UUID customerId) {
        for (Balance giftCardBalance : StaticConstants.GIFT_CARD_BALANCE_LIST) {
            if (giftCardBalance.getCustomerId().toString().equals(customerId.toString())) {
                return (GiftCardBalance) giftCardBalance;
            }
        }
//if customer doesnt have any giftcardbalance assigned as a zero
        GiftCardBalance giftCardBalance = new GiftCardBalance(customerId, 0d);//itisnot inthe database it is now in cloud
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(giftCardBalance);
        return giftCardBalance;

    }
    private static void printAddressByCustomerId(Customer customer) {
        customer.getAdress().stream()
                .map(Objects::toString)
                .forEach(System.out::println);


     /*
        for (Address address : customer.getAddress()) {
            System.out.println(" Street Name: " + address.getStreetName() +
                    " Street Number: " + address.getStreetNumber() + "ZipCode:  "
                    + address.getZipCode() + " State: " + address.getState());
        }

      */
    }

}
