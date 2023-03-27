package org.example;

import jakarta.xml.bind.annotation.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;


@XmlRootElement
@XmlType(propOrder = {"id", "date", "customers", "books"})
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "book_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String date;

    @XmlElementWrapper(name="customers")
    @XmlElement(name="customer")
    @OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
    private List<Customer> customers;

    @XmlElementWrapper(name="books")
    @XmlElement(name="book")
    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
    private List<Book> books;

    public Order(){}

    public Order(int id, String date, List<Customer> customers, List<Book> books) {
        this.id = id;
        this.date = date;
        this.customers = customers;
        this.books = books;
    }

    public Order(String date, List<Customer> customers, List<Book> books) {
        this.date = date;
        this.customers = customers;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return String.format("Order:\n\t Date = %s\n\t" +
                        "Customers: \n\t%s" +
                        "Books:\n\t\t%s",
                this.date,
                this.customers,
                this.books,
                constructCustomerString(),
                constructBookString());
    }

    private String constructCustomerString(){
        String resultCustomer = "";
        for(Customer customer : this.customers){
            resultCustomer += customer.toString();
        }
        return resultCustomer;
    }

    private String constructBookString(){
        String resultBook = "";
        for(Book book : this.books){
            resultBook += book.toString();
        }
        return resultBook;
    }
}
