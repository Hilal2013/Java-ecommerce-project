import balance.Balance;
import category.Category;
import customer.Customer;
import discount.Discount;

import java.util.ArrayList;
import java.util.List;

public class StaticConstants {
    public static final List<Customer> CUSTOMER_LIST=new ArrayList<>();
//final because this is database it shouldn't be changed at all
    //static because i wont create object. call with class name
public static final List<Category> CATEGORY_LIST=new ArrayList<>();
public static final List<Product> PRODUCT_LIST=new ArrayList<>();
public static final List<Balance> CUSTOMER_BALANCE_LIST=new ArrayList<>();
    public static final List<Balance> GIFT_CARD_BALANCE_LIST=new ArrayList<>();
    public static final List<Discount> DISCOUNT_LIST=new ArrayList<>();

}
