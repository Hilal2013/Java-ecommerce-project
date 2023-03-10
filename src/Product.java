import category.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private Double price;
    private Integer stock, remainingStock;
    public UUID categoryID;

    public Product(UUID id, String name, Double price, Integer stock, Integer remainingStock, UUID categoryID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.remainingStock = remainingStock;
        this.categoryID = categoryID;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getRemainingStock() {
        return remainingStock;
    }

    public UUID getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() throws Exception {

        for(Category category : StaticConstants.CATEGORY_LIST){
            if(getCategoryID().toString().equals(category.getId().toString())){
                return category.getName();
            }
        }
        throw new Exception("Category not found," + getName());

    }

    public LocalDateTime getDeliveryDueDate() throws Exception {
//dueDate is inside the category//find the category and check the delivery duedate//
     //Im checking each categories whenever I found the category of product that im trying to choose
        //im returning duedate
        for(Category category : StaticConstants.CATEGORY_LIST){
            if(getCategoryID().toString().equals(category.getId().toString())){
                return category.findDeliveryDueDate();
            }
        }
      //if i cannnot find anything I will say this category is not existing
        throw new Exception ("Category could not find");

    }


}
//you have the category id please go to database and check all category ids and find matching one and return the category name

//return null//null isnt good//instead of null throw exception

//we created new object belongs to Exception class
//i dont want to sop application i wanna handle. it can give me warning but it should be up and running