package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_produit;
    private String name;
    private double price;

    public Produit(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Produit() {}
}
