import category.CategoryParent;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {


    private String name;
    private Double price;
    private int stock , remainingStock;
    private UUID id , categoryID;

    public Product(String name, Double price, int stock, int remainingStock, UUID id, UUID categoryID) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.remainingStock = remainingStock;
        this.id = id;
        this.categoryID = categoryID;
    }


    public LocalDateTime getDeliveryDueDate() throws Exception {
        for (CategoryParent category : StaticConstants.CATEGORY_LIST) {
            if (getCategoryID().toString().equals(category.getId().toString())) {
                return category.calcDeliveryDate();
            }
        }
        throw new Exception("Category Not Found");
        //return getDeliveryDueDate();
    }




    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getRemainingStock() {
        return remainingStock;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCategoryID() {
        return categoryID;
    }





}
