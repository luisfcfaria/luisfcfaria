package mindswap.academy.services;

import mindswap.academy.persistence.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;



public class CustomerService {

    private EntityManagerFactory emf;


    public CustomerService() {
       emf = Persistence.createEntityManagerFactory("mindswap");
    }

    public void printClientById(Integer id){
        EntityManager em = null;

        try{
            em = emf.createEntityManager();
            Customer customer = em.find(Customer.class, id);
            System.out.println(customer);

        } finally {
            if(em != null){
                em.close();
            }
        }
    }

    public void printAllCustomers(){
        EntityManager em = null;

        try{
            em = emf.createEntityManager();
            CriteriaQuery<Customer> query = em.getCriteriaBuilder().createQuery(Customer.class);
            query.select(query.from(Customer.class));
            Query query1 = em.createQuery("SELECT s from Customer s");
            List resultList = query1.getResultList();
            System.out.println(resultList);

        } finally {
            if(em != null){
                em.close();
            }
        }
    }

}
