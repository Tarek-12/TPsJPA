package ma.cigma.presentation;

import ma.cigma.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import ma.cigma.services.IClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/client"))
public class ClientController {
    @Autowired
    IClientService service;

    @PostMapping("/add")
    public Client save(@RequestBody Client c) {
        return service.save(c);
    }
    @PutMapping("/update")
    public Client modify(@RequestBody Client c) {
        return service.modify(c);
    }
    @DeleteMapping("/{idClient}")
    public void remove(@PathVariable("idClient") long idClient) {
        service.remove(idClient);
    }
    @GetMapping("/{idClient}")
    public Client getOne(@PathVariable("idClient") long idClient) {
        return service.getOne(idClient);
    }
    @GetMapping("/all")
    public List<Client> getAll() {
        return service.getAll();
    }
}
