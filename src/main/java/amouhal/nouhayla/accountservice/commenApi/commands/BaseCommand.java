package amouhal.nouhayla.accountservice.commenApi.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand <T> {
    public BaseCommand(T id) {
        this.id = id;
    }

    @TargetAggregateIdentifier
    @Getter T id;
}
