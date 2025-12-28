package amouhal.nouhayla.accountservice.commenApi.commands;

import org.axonframework.modelling. command.TargetAggregateIdentifier;

public class CreateAccountCommand extends BaseCommand<String> {
    @TargetAggregateIdentifier
    private String id;
    private double initialBalance;
    private String currency;

    public CreateAccountCommand(String id, double initialBalance, String currency) {
        super(id);
        this.id = id;
        this.initialBalance = initialBalance;
        this. currency = currency;
    }

    // Getters
    public String getId() {
        return id;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public String getCurrency() {
        return currency;
    }
}