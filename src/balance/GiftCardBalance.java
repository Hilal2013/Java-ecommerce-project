package balance;

import customer.Customer;

import java.util.UUID;

public class GiftCardBalance extends Balance {

    public GiftCardBalance(UUID customerId, Double balance) {
        super(customerId, balance);
    }

    @Override
    public Double addBalance(Double additionalBalance) {//increase the balance with additional amount
        double promotionAmount = additionalBalance * 10 / 100;
        setBalance(getBalance() + additionalBalance + promotionAmount);
        return getBalance();
    }
}
