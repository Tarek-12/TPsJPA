package models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class LigneFacture {
    @EmbeddedId
    private Pk Pk_id = new Pk();
    private double qte;

    @ManyToOne
    @MapsId(value = "id_facture")
    @JoinColumn(name = "ID_FACTURE")
    private Facture facture;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @MapsId(value = "id_produit")
    @JoinColumn(name = "ID_PRODUIT")
    private Produit produit;

    public LigneFacture() {
    }

    public LigneFacture(double qte, Produit produit, Facture facture) {
        this.qte = qte;
        this.produit = produit;
        this.facture = facture;
    }
}
