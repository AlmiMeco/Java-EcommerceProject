package balance;

import java.util.UUID;

public class GiftCardBalance extends BalanceParent{


    public GiftCardBalance(UUID customerID, Double balance) {
        super(customerID, balance);
    }

    @Override
    public Double addBalance(Double moneyAddedToBalance) {
        double promotionalAmount = moneyAddedToBalance * 10 / 100;
        setBalance( getBalance() + moneyAddedToBalance + promotionalAmount );
        return getBalance();
    }





}
