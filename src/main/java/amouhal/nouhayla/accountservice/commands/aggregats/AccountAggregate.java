package amouhal.nouhayla.accountservice.commands.aggregats;


import amouhal.nouhayla.accountservice.commenApi.AccountStatus;
import amouhal.nouhayla.accountservice.commenApi.commands.CreateAccountCommand;
import amouhal.nouhayla.accountservice.commenApi.events.AccountCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateRoot;


public class AccountAggregate {
    @AggregateIdentifier
    private String AccountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public AccountAggregate() {
        //required by axon
    }
    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        if(command.getInitialBalance()<0) throw new RuntimeException("Impossible to create an account with negative balance");
            AggregateLifecycle.apply(new AccountCreatedEvent(
                    command.getId(),
                    command.getInitialBalance(),
                    command.getCurrency(),
                    AccountStatus.CREATED
            ));
        }
    }

