package CodingAssessment1;

public class Account {

    private Integer accNumber;
    private String custName;
    private AccountType type; 
    private Float balance;

    
    public enum AccountType {
        SAVINGS,
        CURRENT
    }

    
    public Account(Integer accNumber, String custName, AccountType type, Float balance) throws LowBalanceException, InvalidAmountException {
        if (balance < 0) {
            throw new InvalidAmountException("Balance cannot be negative.");
        }

        this.accNumber = accNumber;
        this.custName = custName;
        this.type = type;
        this.balance = balance;

        if (type == AccountType.SAVINGS && balance < 1000) {
            throw new LowBalanceException("Minimum balance of Rs.1000/- required for Savings account.");
        } else if (type == AccountType.CURRENT && balance < 5000) {
            throw new LowBalanceException("Minimum balance of Rs.5000/- required for Current account.");
        }
    }

  
    public Integer getAccNumber() {
        return accNumber;
    }

    public String getCustName() {
        return custName;
    }

    public AccountType getType() {
        return type;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
