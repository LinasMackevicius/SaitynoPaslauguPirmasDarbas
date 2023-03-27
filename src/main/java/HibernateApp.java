
import Util.HibernateUtil;
import Util.JaxbUtil;
import org.example.Book;
import org.example.Customer;
import org.example.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args){

        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1989, "Someone", 55);
        Customer customer1 = new Customer("John", "Smith");
        Order order1 = new Order("2023-04-05", List.of(customer1), List.of(book1));

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(order1);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Order> orders = session.createQuery("from Order", Order.class).list();
            orders.forEach(ordr -> System.out.println());

            System.out.println("---------------------------------");
            orders.forEach(ordr -> JaxbUtil.convertToXML(ordr));

            //server = Server.createTcpServer().start();
            System.in.read();
        }catch (Exception e){
            if(transaction != null){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            //server.shutdown();
        }
    }
}
