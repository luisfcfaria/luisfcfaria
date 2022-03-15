package academy.mindswap.services;

import academy.mindswap.persistence.Student;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class StudentService {

    private EntityManagerFactory emf;

    public StudentService() {
        emf = Persistence.createEntityManagerFactory("mindswap");
    }

    public void printStudentById(Integer id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Student student = em.find(Student.class, id);
            System.out.println(student);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void printAllStudents() {
        EntityManager em = null;
        try {

            em = emf.createEntityManager();
            CriteriaQuery<Student> query = em.getCriteriaBuilder().createQuery(Student.class);
            query.select(query.from(Student.class));

            List<Student> resultList = em.createQuery(query).getResultList();
            System.out.println(resultList);

            Query query1 = em.createQuery("SELECT s from Student s");
            List resultList2 = query1.getResultList();

//            System.out.println(resultList2);

        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void createOrUpdateStudent(Integer id, String name, Integer edition) {
        Student student = new Student(id, name, edition);
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();

        } catch (RollbackException e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }


    }
}
