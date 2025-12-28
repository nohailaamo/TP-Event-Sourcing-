package amouhal.nouhayla.accountservice.commenApi.events;

import amouhal.nouhayla.accountservice.commenApi.AccountStatus;
import lombok.Getter;

public class AccountCreatedEvent extends BaseEvent<String> {

    private double initialBalance;
    private String currency;

    public double getInitialBalance() {
        return initialBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    private AccountStatus status;

    public AccountCreatedEvent(String id, double initialBalance, String currency, AccountStatus status) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
        this.status = status;
    }

}
