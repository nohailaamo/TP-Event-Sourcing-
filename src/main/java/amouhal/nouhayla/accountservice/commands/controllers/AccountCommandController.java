package amouhal.nouhayla.accountservice.commands.controllers;

import amouhal.nouhayla.accountservice.commenApi.commands.CreateAccountCommand;
import amouhal.nouhayla.accountservice.commenApi.dto.CreateAccountDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/account")
@AllArgsConstructor
public class AccountCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountDTO request) {
        CompletableFuture<String> result = commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                request.currency(),
                request.initialBalance()
        ));
        return result;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception exception){
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }
}