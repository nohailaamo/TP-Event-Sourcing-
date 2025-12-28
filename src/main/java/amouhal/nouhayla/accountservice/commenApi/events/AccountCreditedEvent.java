package amouhal.nouhayla.accountservice.commenApi.events;

public class AccountCreditedEvent extends BaseEvent<String> {
    public String getAccountId() {
        return accountId;
    }

    private String accountId;
    private double amount;
    private String currency;

    public AccountCreditedEvent(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
