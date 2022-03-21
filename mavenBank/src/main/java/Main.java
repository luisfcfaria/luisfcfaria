import mindswap.academy.services.AccountService;
import mindswap.academy.services.CustomerService;

public class Main {

    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        CustomerService customerService = new CustomerService();


        accountService.printAccountBalanceById(2);
        accountService.printClientAccountsById(2);
    }

}
