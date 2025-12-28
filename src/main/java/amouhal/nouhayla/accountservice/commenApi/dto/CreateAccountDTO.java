package amouhal.nouhayla.accountservice.commenApi.dto;

public class CreateAccountDTO {
    private double initialBalance;
    private String currency;

    // Getters
    public double getInitialBalance() {
        return initialBalance;
    }

    public String getCurrency() {
        return currency;
    }

    // Setters
    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}