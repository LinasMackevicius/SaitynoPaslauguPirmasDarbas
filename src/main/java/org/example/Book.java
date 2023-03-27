package org.example;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String bookName;
    private String author;
    private int year;
    private String publisher;
    private int price;

    public Book() {
    }

    public Book(int id, String bookName, String author, int year, String publisher, int price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.price = price;
    }

    public Book(String bookName, String author, int year, String publisher, int price) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("\tBook:\n\t\t\t\t" + "BookName = %s\n\t\t\t\t" + "Author = %s\n\t\t\t\t" +
                        "year = %s\n\t\t\t\t" + "Publisher = %s\n\t\t\t\t" + "Price = %s\n\t\t\t\t",
                this.bookName,
                this.author,
                this.year,
                this.publisher,
                this.price);
    }
}
