import category.Category;

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

    public String getProductCategoryName() throws Exception {
        //you have the category id please go to database and check all category ids and find matching one and return the category name

        for(Category category: StaticConstants.CATEGORY_LIST){
            if(getCategoryID().toString().equals(category.getId().toString()));
            return category.getName();
        }
        //return null//null isnt good//instead of null throw exception
        throw new Exception("Category not found," + getName());
        //we created new object belongs to Exception class
        //i dont want to sop application i wanna handle. it can give me warning but it should be up and running
    }

}
