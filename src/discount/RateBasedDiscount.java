package discount;

import java.util.UUID;

public class RateBasedDiscount extends Discount{
    private Double rateAmount;

    public RateBasedDiscount(UUID discountId, String name, Double thresholdAmount, Double rateAmount) {
        super(discountId, name, thresholdAmount);
        this.rateAmount = rateAmount;
    }

    public Double getRateAmount() {
        return rateAmount;
    }

    @Override
    public Double calculateCartAmountAfterDiscountApplied(Double amount) {
        return amount - (amount * rateAmount / 100) ;

        // 400 %15 = 340
    }
}
