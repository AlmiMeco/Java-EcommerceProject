package discount;

import java.util.UUID;

public abstract class DiscountParent {


    private UUID id;
    private String discountName;
    private Double thresholdAmount;



    public DiscountParent(UUID id, String discountName, Double thresholdAmount) {
        this.id = id;
        this.discountName = discountName;
        this.thresholdAmount = thresholdAmount;

    }

    public UUID getId() {
        return id;
    }

    public String getDiscountName() {
        return discountName;
    }

    public Double getThresholdAmount() {
        return thresholdAmount;
    }


    public abstract Double calculateCartBalanceAfterDiscountApplied(Double amount);

}
