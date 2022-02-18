package models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id_client;
    private String name;

    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "client")
    private Adresse adresses;

    public Client() {
    }
    public Client(String name) {
        this.name = name;
    }
}
