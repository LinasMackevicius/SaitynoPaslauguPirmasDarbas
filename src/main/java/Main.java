import Util.JaxbUtil;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.Book;
import org.example.Customer;
import org.example.Order;

import java.io.IOException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {

        Book book1 = new Book("Harry Potter","J.K.Rowling", 1998, "Alma Littera", 25 );
        Book book2 = new Book("The witcher","A.Tolkien", 1998, "Tito Alba", 69 );

        Customer customer1 = new Customer("Vaiva", "Mackevičaitė");
        Customer customer2 = new Customer("Daiva", "Vilnietė");

        Order order1 = new Order("2023-03-01", List.of(customer1, customer2), List.of(book1,book2));
        JaxbUtil.convertToXML(order1);
        System.out.println(order1);
    }
}