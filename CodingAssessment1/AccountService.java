package CodingAssessment1;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private List<Account> accountList = new ArrayList<>();

   
    public AccountService() {
        try {
            accountList.add(new Account(101, "Alice", Account.AccountType.SAVINGS, 1500f));
            accountList.add(new Account(102, "Bob", Account.AccountType.CURRENT, 6000f));
            accountList.add(new Account(103, "Charlie", Account.AccountType.SAVINGS, 3000f));
            accountList.add(new Account(104, "David", Account.AccountType.CURRENT, 7000f));
            accountList.add(new Account(105, "Eve", Account.AccountType.SAVINGS, 1200f));
        } catch (Exception e) {
            System.out.println("Error initializing accounts: " + e.getMessage());
        }
    }

   
    public boolean isValidAccount(int accNumber) throws AccountNotFoundException {
        for (Account account : accountList) {
            if (account.getAccNumber() == accNumber) {
                return true;
            }
        }
        throw new AccountNotFoundException("Account not found.");
    }

   
    public void deposit(int accNumber, float amt) throws InvalidAmountException, AccountNotFoundException {
        if (amt < 0) {
            throw new InvalidAmountException("Deposit amount cannot be negative.");
        }

        Account account = getAccount(accNumber);
        account.setBalance(account.getBalance() + amt);
    }

    public void withdraw(int accNumber, float amt) throws InsufficientFundsException, InvalidAmountException, AccountNotFoundException {
        if (amt < 500) {
            throw new InvalidAmountException("Minimum withdrawal amount is Rs.500/-");
        }

        Account account = getAccount(accNumber);
        if (account.getType() == Account.AccountType.SAVINGS && account.getBalance() - amt < 1000) {
            throw new InsufficientFundsException("Insufficient funds. Minimum balance of Rs.1000/- required for Savings account.");
        } else if (account.getType() == Account.AccountType.CURRENT && account.getBalance() - amt < 5000) {
            throw new InsufficientFundsException("Insufficient funds. Minimum balance of Rs.5000/- required for Current account.");
        }

        account.setBalance(account.getBalance() - amt);
    }

   
    public float getBalance(int accNumber) throws AccountNotFoundException {
        Account account = getAccount(accNumber);
        return account.getBalance();
    }

    private Account getAccount(int accNumber) throws AccountNotFoundException {
        for (Account account : accountList) {
            if (account.getAccNumber() == accNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found.");
    }
}
