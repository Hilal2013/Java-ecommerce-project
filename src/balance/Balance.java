package balance;

import java.util.UUID;

public abstract class Balance {
    //first we will decide there is inheritance or not
//Customer has 2 kinds of balance in their acount //customerBalance and GiftCard Balance
    //common features
    private UUID customerId;
    private Double balance;

    public Balance(UUID customerId, Double balance) {
        this.customerId = customerId;
        this.balance = balance;
    }

    public abstract Double addBalance(Double additionalBalance);
    // I have a different adding balance functions for balance types which I don’t know the implementation
    // calculation at the beginning. I  define this method as an abstract method.


    public UUID getCustomerId() {
        return customerId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
