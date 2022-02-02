import models.Facture;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.FactureController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ApplicationRunner {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        FactureController facture = (FactureController) context.getBean("idFact");

        //Add Factures
        facture.save(new Facture((simpleDateFormat.parse("09/01/2022")), 600.00));
        facture.save(new Facture((simpleDateFormat.parse("10/01/2022")), 800.50));
        //Modify Facture with id 1
//        facture.update(new Facture(1L, (simpleDateFormat.parse("15/01/2022")), 600.00));
        //Remove Facture with id 1
//        facture.deleteById(1L);
        //Find Facture with id 1
//        Facture found = facture.findById(1L);
//        System.out.println(found);
        //Select all Factures
//        List<Facture> l = facture.findAll();
//        System.out.println(l);
    }
}
