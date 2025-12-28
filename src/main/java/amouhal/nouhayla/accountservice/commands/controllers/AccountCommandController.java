package amouhal.nouhayla.accountservice.commands.controllers;

import amouhal.nouhayla.accountservice.commenApi.commands. CreateAccountCommand;
import amouhal.nouhayla.accountservice.commenApi.commands.CreditAccountCommand;
import amouhal.nouhayla.accountservice.commenApi.dto.CreateAccountDTO;
import amouhal.nouhayla.accountservice.commenApi.dto.CreditAccountDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/account")
public class AccountCommandController {

    private final CommandGateway commandGateway;

    // Constructeur manuel
    public AccountCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountDTO request) {
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                request.getInitialBalance(),
                request.getCurrency()
        ));
    }
    @PostMapping("/credit")
    public CompletableFuture<String> creditAccount(@RequestBody CreditAccountDTO request) {
        return commandGateway.send(new CreditAccountCommand(
                request.getAccountId(),
                request.getAmount(),
                request.getCurrency()
        ));
    }
}