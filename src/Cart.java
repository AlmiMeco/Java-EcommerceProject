import java.util.Map;
import java.util.UUID;

public class Cart {


    private Customer customer;
    private UUID dicountID;
    private Map<Product, Integer> productMap;


    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Cart(Customer customer, UUID dicountID, Map<Product, Integer> productMap) {
        this.customer = customer;
        this.dicountID = dicountID;
        this.productMap = productMap;
    }



    public Double calculateCartTotal() {
        double totalAmount = 0;
        for (Product product : productMap.keySet()) {
            totalAmount += product.getPrice() * productMap.get(product);
        }
        return totalAmount;
    }




    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UUID getDicountID() {
        return dicountID;
    }

    public void setDicountID(UUID dicountID) {
        this.dicountID = dicountID;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }






}
