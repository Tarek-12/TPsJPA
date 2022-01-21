package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "LigneFacture", joinColumns = @JoinColumn(name = "produit_fk", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "facture_fk", referencedColumnName = "id"))
    private List<Facture> factures;

    public Produit(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Produit() {}
}
