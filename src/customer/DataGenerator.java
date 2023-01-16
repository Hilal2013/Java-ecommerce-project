package customer;

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
}
