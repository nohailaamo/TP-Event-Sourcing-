package amouhal.nouhayla.accountservice.commenApi.commands;

public class CreditAccountCommand extends BaseCommand<String> {
    public String getAccountId() {
        return accountId;
    }

    private String accountId;
    private double amount;
    private String currency;

    public CreditAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
