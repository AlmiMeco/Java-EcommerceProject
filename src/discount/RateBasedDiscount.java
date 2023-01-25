package discount;

import java.util.UUID;

public class RateBasedDiscount extends DiscountParent{

    private Double discountPercentageRate;

    public RateBasedDiscount(UUID id, String discountName, Double thresholdAmount, Double discountPercentageRate) {
        super(id, discountName, thresholdAmount);
        this.discountPercentageRate = discountPercentageRate;
    }

    public Double getDiscountPercentageRate() {
        return discountPercentageRate;
    }

    @Override
    public Double calculateCartBalanceAfterDiscountApplied(Double amount) {
        return null;
    }
}
