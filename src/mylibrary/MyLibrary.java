/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibrary;

import classes.Book;
import classes.Pupil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author cawa4
 */
public class MyLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Book book1 = new Book("Дж. Блох", "Эффектное программирование на Java", "3 недели");
        Book book2 = new Book("Мария Иванова", "Работа и деньги", "4 недели");
        Pupil pupil1 = new Pupil("Александр", "Кропачев","39909022220", "11а", new ArrayList<Book>());
        pupil1.addBook(book1);
        pupil1.addBook(book2);

        System.out.println(pupil1.toString());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyLibraryPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(pupil1);
        //Pupil pupilFromDB = em. find(Pupil.class, 1L);
        //pupilFromDB.removeBook(book2);
        //Query query = em.createQuery("SELECT r FROM Pupil r WHERE r.firstname=: AND r.lastname=:");
        //query.setParameter("fistname", "Александр");
        //query.setParameter("lastname", "Кропачев");
        //Pupil pupil1FromDB = (Pupil) query.getSingleResult();
        //System.out.println(pupil1FromDB.toString());
        //pupil1FromDB.addBook(book2);
        //em.merge(pupil1FromDB);

        em.persist(pupil1);
        tx.commit();

        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

}
