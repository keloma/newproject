/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.Book;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author cawa4
 */
@Entity
public class Pupil extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String klass;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Book> books;

    public Pupil() {
    }

    public Pupil(String firstname, String lastname, String code, String klass, List<Book> books) {
        super(firstname, lastname, code);
        this.books = books;
        this.klass = klass;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        for (int i = 0; i < this.books.size(); i++) {
            this.books.remove(i);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.klass);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pupil other = (Pupil) obj;
        if (!Objects.equals(this.klass, other.klass)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String strBooks = "";
        for (int i = 0; i < this.books.size(); i++) {
            strBooks += this.books.get(i);

        }
        return "\n Pupil{" + "\n Имя: " + super.getFistname()
                + "\n Фамилия: " + super.getLastname()
                + "\n Класс: " + klass
                + "\n Код: " + super.getCode()
                + "\n Книги: " + strBooks + '}';
    }

    
    
    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

}
