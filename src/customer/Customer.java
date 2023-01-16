package customer;

import customer.Address;

import java.util.List;
import java.util.UUID;

public class Customer {
private UUID id;//to find unique
    private String userName,email;
    //my customer  has object of address
//{hilal,hilal@cydeo.com,{7823,abcstreet,22000}};=>customer.Customer object
  //  private customer.Address address;//we have one addres for multiple adress
    //more than one meaning list
//private ArrayList<customer.Address> adress;//it is ok but not preferable
    private List<Address> address;//for polymorhism //thigives flexibility//always put Interface  not class

    public Customer(UUID id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public Customer(UUID id, String userName, String email, List<Address> address) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public List<Address> getAdress() {
        return address;
    }


}
