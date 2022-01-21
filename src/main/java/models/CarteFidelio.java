package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class CarteFidelio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public CarteFidelio(String code) {
        this.code = code;
    }

    public CarteFidelio() {}
}
