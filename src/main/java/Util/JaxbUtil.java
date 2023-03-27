package Util;

import org.example.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbUtil {

    public static void convertToXML(Order order){
        try{
            JAXBContext context = JAXBContext.newInstance(Order.class);

            Marshaller marshaller = null;

            marshaller = context.createMarshaller();

            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

           // OutputStream os = new FileOutputStream("generated.xml");

            marshaller.marshal(order, new File("order.xml"));

            marshaller.marshal(order, System.out);
        }catch (/*FileNotFoundExeption | */ JAXBException e){
            throw new RuntimeException(e);
        }
    }

    public static void convertToPojo()
    {
        String fileName = "order.xml";
        File xmlFile = new File(fileName);

        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Order.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Order employee = (Order) jaxbUnmarshaller.unmarshal(xmlFile);

            System.out.println(employee);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
