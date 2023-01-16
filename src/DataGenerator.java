import category.Category;
import category.Electronic;
import category.Furniture;
import category.SkinCare;
import customer.Address;
import customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {
//Im gonna create sample costumers . i dont want to create in main method

    //im gonnna create create costumer ()
    public static void createCustomer() {

        Address address1Customer1=new Address("7925","Jones Branch Dr","suite 3300","22100","VA");
        Address address2Customer1=new Address("7926","George Town Dr","suite 200","2200","VA");
        Address address1Customer2=new Address("7927","Lee Hwy Dr","suite 1000","22110","VA");
        List<Address> customer1AddressList = new ArrayList<>();
        customer1AddressList.add(address1Customer1);
        customer1AddressList.add(address2Customer1);
Customer customer1=new Customer(UUID.randomUUID(),"hilal","hilal@cydeo.com", customer1AddressList);
//I can create other customer object without address
        Customer customer2=new Customer(UUID.randomUUID(),"ozzy","ozzy@cydeo.com");
        //I had created two customer and Im gonna put in my database(staticConstant)
StaticConstants.CUSTOMER_LIST.add(customer1);
StaticConstants.CUSTOMER_LIST.add(customer2);


    }


    public static void createCategory() {
Category category1 =new Electronic(UUID.randomUUID(),"Electronic");
        Category category2 =new Furniture(UUID.randomUUID(),"Furniture");
                Category category3 = new SkinCare(UUID.randomUUID(),"SkinCare");

StaticConstants.CATEGORY_LIST.add(category1);
        StaticConstants.CATEGORY_LIST.add(category2);
        StaticConstants.CATEGORY_LIST.add(category3);



    }


    public static void createProduct() {

        Product product1 =new Product(UUID.randomUUID(),"PS5",230.72,7,7,StaticConstants.CATEGORY_LIST.get(0).getId());
        Product product2 =new Product(UUID.randomUUID(),"XBOX",100.5,15,15,StaticConstants.CATEGORY_LIST.get(0).getId());
        Product product3 =new Product(UUID.randomUUID(),"FS4",30.72,80,80,StaticConstants.CATEGORY_LIST.get(1).getId());
StaticConstants.PRODUCT_LIST.add(product1);
        StaticConstants.PRODUCT_LIST.add(product2);
        StaticConstants.PRODUCT_LIST.add(product3);
    }
}
