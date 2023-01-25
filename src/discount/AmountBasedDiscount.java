package discount;

import java.util.UUID;

public class AmountBasedDiscount extends DiscountParent{


    private Double discountAmount;

    public AmountBasedDiscount(UUID id, String discountName, Double thresholdAmount, Double discountAmount) {
        super(id, discountName, thresholdAmount);
        this.discountAmount = discountAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public Double calculateCartBalanceAfterDiscountApplied(Double amount) {
        return null;
    }


}

