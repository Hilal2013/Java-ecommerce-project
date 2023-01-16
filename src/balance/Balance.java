package balance;

import java.util.UUID;

public abstract class Balance {
    private UUID customerID;
    private Double balance;

    public Balance(UUID customerID, Double balance) {
        this.customerID = customerID;
        this.balance = balance;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public abstract Double addBalance(Double additionalBalance);
}
