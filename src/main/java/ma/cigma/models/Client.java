package ma.cigma.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;

    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "client")
    private Adresse adresses;

    public Client() {
    }
    public Client(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}
