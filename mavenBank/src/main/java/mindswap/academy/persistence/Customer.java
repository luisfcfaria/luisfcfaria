package mindswap.academy.persistence;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")

public class Customer {

    @Id
    @Column
    private Integer customerId;
    private String name;

    @OneToMany (cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "customers")
    private Set<Accounts> accounts;

    public void addAccount(Accounts account){
        accounts.add(account);
        account.setCustomers(this);
    }


    public Customer(Integer idNumber, String name) {
        this.customerId = idNumber;
        this.name = name;
    }

    public Customer(){}

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Accounts> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idNumber=" + customerId +
                ", name='" + name +
                '}';
    }
}

