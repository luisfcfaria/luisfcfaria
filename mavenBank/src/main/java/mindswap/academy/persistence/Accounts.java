package mindswap.academy.persistence;


import javax.persistence.*;

@Entity
@Table(name = "accounts")

public class Accounts {
    @Id
    @Column
    private Integer accountNumber;
    private Integer balance;

    @ManyToOne
    private Customer customers;


    public Accounts(Integer accountNumber, Integer balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Accounts(){}

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
