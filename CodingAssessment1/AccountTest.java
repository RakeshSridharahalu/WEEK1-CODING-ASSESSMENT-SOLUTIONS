package CodingAssessment1;
public class AccountTest {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();

        try {
            
            System.out.println("Balance of account 101: " + accountService.getBalance(101));
            accountService.deposit(101, 1000f);
            System.out.println("Balance of account 101 after deposit: " + accountService.getBalance(101));

          
            accountService.withdraw(101, 400f);
            System.out.println("Balance of account 101 after withdrawal: " + accountService.getBalance(101));

        } catch (AccountNotFoundException | InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
