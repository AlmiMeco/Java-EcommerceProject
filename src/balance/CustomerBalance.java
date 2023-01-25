package balance;

import java.util.UUID;

public class CustomerBalance extends BalanceParent{


    public CustomerBalance(UUID customerID, Double balance) {
        super(customerID, balance);
    }

    public Double addBalance(Double moneyAddedToBalance) {
        setBalance( getBalance() + moneyAddedToBalance ) ;
        return getBalance();
    }
}
