import models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.ClientController;
import presentation.ProduitController;

import java.util.*;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctr = (ClientController) ctx.getBean("idCtrl");
        ProduitController pctr = (ProduitController) ctx.getBean("idProd");
        //Instanciation des adresses
        Set<Adresse> adresses = new HashSet<>();
        Adresse a1 = new Adresse("Bd Med V, Rue 14, N15", "Casablanca", "Maroc");
        Adresse a2 = new Adresse("Bd 2Mars, Rue 1, N45", "Casablanca", "Maroc");
        adresses.add(a1);
        adresses.add(a2);
        //Instanciation des promo carte fideolio, client, facture, et produit
        List<Promotion> promotions = Arrays.asList(new Promotion("remise 10%"), new Promotion("solde 40%"));
        CarteFidelio carteFidelio = new CarteFidelio("A456231656");
        Client client = new Client("OMAR");
        Produit p = new Produit("Cable RJ45, 15M", 100.0d);
        List<Facture> factures = Arrays.asList(new Facture(7100.0d, "facture 1"), new Facture(13000.0d, "facture 2"));
        //Ajout des produit a la BD
        pctr.save(p);
        //Ajout des attribut de la table client
        client.setFacture(factures);
        client.setPromotions(promotions);
        carteFidelio.setClient(client);
        client.setCarteFidelio(carteFidelio);
        client.setAdresse(adresses);
        p.setFactures(factures);
        //Ajout du client a la BD
        ctr.save(client);
    }
}
