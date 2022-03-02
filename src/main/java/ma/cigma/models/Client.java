package ma.cigma.models;

import lombok.Data;

@Data
public class Client {
    private long id;
    private String name;

    public Client() {
    }
    public Client(String name) {
        this.name = name;
    }
}
