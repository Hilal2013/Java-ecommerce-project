import category.Category;
import customer.Customer;
import discount.Discount;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        //createCustomer();we should import we should call through classname
DataGenerator.createCustomer();
        DataGenerator.createCategory();
DataGenerator.createProduct();
DataGenerator.createBalance();
DataGenerator.createDiscount();

        Scanner scanner=new Scanner(System.in);
        System.out.println("Select Customer");
        for (int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); i++) {
            System.out.println("Type "+i+" for customer: "+StaticConstants.CUSTOMER_LIST.get(i).getUserName());
        }
//I need to capture object
Customer customer=StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());
        //right now customer logged in system
     //example on amazon you add products on card//you are done no
        // whenever you loged out your application is done//

while(true){
    System.out.println("What would you like to do? just type id for selection");
    for(int i=0; i<prepareMenuOptions().length;i++){
        System.out.println(i+"-"+prepareMenuOptions()[i]);
    }
    int menuSelection=scanner.nextInt();

    switch(menuSelection){
        case 0://list categories
            for (Category category : StaticConstants.CATEGORY_LIST) {
                System.out.println("Category Code "+category.generateCategoryCode()+" category name: "+category.getName());
            }
        break;
        case 1://list products//product name,product categoryname
            try{
                for (Product product : StaticConstants.PRODUCT_LIST) {
                    System.out.println("Product name: "+product.getName()+" Product Category Name: "+product.getProductCategoryName());
                }

            }catch(Exception e){
                System.out.println("Product could not printed because category not found for product name:"
                        +e.getMessage().split(",")[1] );
                //getMessage()comes throws from Product class(getProductCategoryName())//my getmessage is holding
                // throw new Exception("Category not found," + getName());

            }
                break;
        case 2://list discounts
            for (Discount discount : StaticConstants.DISCOUNT_LIST) {
                System.out.println("Discount Name: "+ discount.getName()+" Discount threshold amount: "+discount.getThresholdAmount());
            }
            break;
        case 3:
            break;
        case 4:
            break;
        case 5:
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
 //im gonna build this method here and only usage of method is here
    //in the main // no other classes will have access to this method//so private
    //static cannot call nonstatic
    private static String[] prepareMenuOptions(){
        //Im creating menu items

    return new String[]{"List Categories", "List Products","List Discount","See Balance","Add Balance",
    "Place an Order", "See Cart","See Oder Details","See your Adress","Close App"};
    }



}
