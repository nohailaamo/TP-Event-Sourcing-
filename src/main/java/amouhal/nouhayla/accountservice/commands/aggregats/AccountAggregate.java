package amouhal.nouhayla. accountservice.commands.aggregats;

import amouhal.nouhayla.accountservice.commenApi.AccountStatus;
import amouhal.nouhayla.accountservice.commenApi.commands.CreateAccountCommand;
import amouhal.nouhayla.accountservice.commenApi.commands.CreditAccountCommand;
import amouhal.nouhayla.accountservice. commenApi.events.AccountCreatedEvent;
import amouhal.nouhayla.accountservice.commenApi.events.AccountCreditedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    // Constructeur vide requis par Axon
    public AccountAggregate() {
    }

    // CommandHandler pour créer un compte
    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        if(command.getInitialBalance() < 0) {
            throw new RuntimeException("Impossible to create an account with negative balance");
        }

        // Publier l'événement
        AggregateLifecycle.apply(new AccountCreatedEvent(
                command.getId(),
                command. getInitialBalance(),
                command.getCurrency(),
                AccountStatus.CREATED
        ));
    }

    // EventSourcingHandler pour appliquer l'événement
    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        this.accountId = event.getId();
        this.balance = event. getInitialBalance();
        this.currency = event.getCurrency();
        this.status = event.getStatus();
    }

    @CommandHandler
    public void handle(CreditAccountCommand command) {//to be continued
        if(command.getAmount() < 0) {
            throw new RuntimeException("Impossible to credit account with amount greater than balance");
        }
        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getAccountId(),
                command.getAmount(),
                command.getCurrency()
        ));
    }
    @EventSourcingHandler
    public void on(AccountCreditedEvent event) {
        this.accountId = event.getId();
        this.currency = event.getCurrency();
        this.balance += event.getAmount();
    }

}