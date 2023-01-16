package discount;

import java.util.UUID;

public abstract  class Discount {
    private UUID discountId;
    private String name;
    private Double thresholdAmount;

    public Discount(UUID discountId, String name, Double thresholdAmount) {
        this.discountId = discountId;
        this.name = name;
        this.thresholdAmount = thresholdAmount;
    }

    public abstract Double calculateCartAmountAfterDiscount(Double amount);

    public UUID getDiscountId() {
        return discountId;
    }

    public String getName() {
        return name;
    }

    public Double getThresholdAmount() {
        return thresholdAmount;
    }
}
