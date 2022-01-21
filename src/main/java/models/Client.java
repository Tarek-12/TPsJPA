package models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    private List<Facture> factures;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "my_join_table_client_promotion", joinColumns = @JoinColumn(name = "client_fk", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "promotion_fk", referencedColumnName = "id"))
    private List<Promotion> promotions;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    private CarteFidelio carteFidelio;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    private Set<Adresse> adresses;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public void setFacture(List<Facture> factures) {
        for(Facture facture: factures) {
            facture.setClient(this);
        }
        this.factures = factures;
    }
    public void setAdresse(Set<Adresse> adresses){
        for(Adresse adr: adresses){
            adr.setClient(this);
        }
        this.adresses = adresses;
    }
}
