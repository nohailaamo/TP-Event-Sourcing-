package amouhal.nouhayla.accountservice.commenApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditAccountDTO {
    private String accountId;
    private double amount;
    private String currency;
    // Getters
    public String getAccountId() {
        return accountId;
    }
    public double getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }

    public CreditAccountDTO(double amount, String accountId, String currency) {
        this.amount = amount;
        this.accountId = accountId;
        this.currency = currency;
    }
}
