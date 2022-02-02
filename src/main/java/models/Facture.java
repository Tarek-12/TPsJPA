package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_facture;
    private double amount;
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "facture")
    private List<LigneFacture> ligneFactures = new ArrayList<>();

    public Facture(double amount, String description, Client client) {
        this.amount = amount;
        this.description = description;
        this.client = client;
    }

    public Facture() {}
    public void addFacture(LigneFacture l){
        ligneFactures.add(l);
    }
}
