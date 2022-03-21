package mindswap.academy.services;

import mindswap.academy.persistence.Accounts;
import mindswap.academy.persistence.Customer;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AccountService {

    private EntityManagerFactory emf;

    public AccountService() {
        emf = Persistence.createEntityManagerFactory("mindswap");
    }

    public void printAccountBalanceById(Integer accountID) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Accounts accounts = em.find(Accounts.class, accountID);
            System.out.println(accounts);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * so far this will describe all accounts in bank database
     */

    public void printClientAccountsById(Integer clientID) {
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
//            CriteriaQuery<Accounts> query = em.getCriteriaBuilder().createQuery(Accounts.class);
//            query.select(query.from(Accounts.class));
//            List<Accounts> accountsList = em.createQuery(query).getResultList();
//            System.out.println(accountsList);


        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

//    public void printClientAccounts(Customer client) {
//        EntityManager em = null;
//
//        try {
//            em = emf.createEntityManager();
//            CriteriaQuery<Customer> query = em.getCriteriaBuilder().createQuery(Customer.class);
//            query.select(query.from(Customer.class));
//            List<Customer> accountList = em.createQuery(query).
//        }
//    }

}
