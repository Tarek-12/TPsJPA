import models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.AdresseController;
import presentation.ClientController;

import java.util.*;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctr = (ClientController) ctx.getBean("idCtrl");
        AdresseController adr = (AdresseController) ctx.getBean("idAdrs");

        Client client1 = new Client("Omar");
        Client client2 = new Client("Said");
        Client client3 = new Client("Ahmed");

        Adresse a1 = new Adresse("Bd Med v", "Casablanca", "Maroc");
        Adresse a2 = new Adresse("Bd Hassan 2", "Rabat", "Maroc");

        client1.setAdresses(a1);
        a1.setClient(client1);
        client2.setAdresses(a2);
        a2.setClient(client2);

        //Test 1 => save 3 clients
        client1=ctr.save(client1);
        client2=ctr.save(client2);
        client3=ctr.save(client3);

        // Test2 => getAll Clients before modify and remove
        ctr.getAll().stream()
                .forEach(i-> System.out.println(i));

        // Test3 => getOne Client service
        System.out.println(ctr.getOne(1));

        // Test4 => modify Client service
        client1.setName("Hassan");
        ctr.modify(client1);

        // Test5 => remove Client service
        ctr.remove(2);

        // Test getAll Client after modify and remove
        ctr.getAll().stream()
                .forEach(i-> System.out.println(i));

        // Test getClient by names
        ctr.findByName("ahmed").stream()
                .forEach(i-> System.out.println(i));
    }
}
