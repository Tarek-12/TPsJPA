package models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Pk implements Serializable {
    @Column(name = "ID_PRODUIT")
    private long id_produit;
    @Column(name = "ID_Facture")
    private long id_facture;

    public Pk() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pk pk = (Pk) o;
        return id_produit == pk.id_produit && id_facture == pk.id_facture;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_produit, id_facture);
    }
}
