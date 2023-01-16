package discount;

import java.util.UUID;

public class AmountBasedDiscount extends Discount{

private Double discountAmount;

    public AmountBasedDiscount(UUID discountId, String name, Double thresholdAmount, Double discountAmount) {
        super(discountId, name, thresholdAmount);
        this.discountAmount = discountAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public Double calculateCartAmountAfterDiscount(Double amount) {

        return null;
    }
}
