package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String avenue;
    private String ville;
    private String pays;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Adresse(String avenue, String ville, String pays) {
        this.avenue = avenue;
        this.ville = ville;
        this.pays = pays;
    }
    public Adresse() {}
}
