import models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.ClientController;

import java.util.*;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctr = (ClientController) ctx.getBean("idCtrl");

        Client client = new Client("OMAR");

        //Promotion
        List<Promotion> promotions = Arrays.asList(new Promotion("remise 10%"),
                                                   new Promotion("solde 40%"));
        client.setPromotions(promotions);

        //CarteFidelio
        CarteFidelio carteFidelio = new CarteFidelio("A456231656");
        carteFidelio.setClient(client);
        client.setCarteFidelio(carteFidelio);

        //Address
        Adresse adresse = new Adresse("Bd Med V, Rue 14, N15", "Casablanca", "Maroc");
        client.setAdresses(adresse);
        adresse.setClient(client);

        //Facture
        List<Facture> factures = Arrays.asList(new Facture(1600.0d, "facture 1", client),
                                               new Facture(8999.75d, "facture 2", client));

        //Produit
        Produit p1 = new Produit("Disque dur ssd 512 Go", 800.0d);
        Produit p2 = new Produit("TV Samsung 50' ", 8999.75d);

        //LigneFacture
        LigneFacture l1 =new LigneFacture(2, p1, factures.get(0));
        LigneFacture l2= new LigneFacture(1, p2,factures.get(1));

        //Remplissage des factures
        factures.get(0).addFacture(l1);
        factures.get(1).addFacture(l2);
        client.setFactures(factures);

        //Save client and facture
        ctr.save(client);
    }
}
