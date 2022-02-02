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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_client;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client")
    private List<Facture> factures;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "client_promotion", joinColumns =
        @JoinColumn(
                name = "client_fk", referencedColumnName = "id_client"), inverseJoinColumns =
        @JoinColumn(
                name = "promotion_fk", referencedColumnName = "id_promotion"))
    private List<Promotion> promotions;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    private CarteFidelio carteFidelio;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    private Adresse adresses;

    public Client() {
    }
    public Client(String name) {
        this.name = name;
    }
}
