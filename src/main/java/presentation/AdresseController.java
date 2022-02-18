package presentation;

import models.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.IAdresseService;

import java.util.List;

@Controller("idAdrs")
public class AdresseController {
    @Autowired
    IAdresseService service;

    public Adresse save(Adresse adresse) { return service.save(adresse); }
    public Adresse modify(Adresse adresse) { return service.modify(adresse); }
    public void remove(long idAdresse) { service.remove(idAdresse); }
    public Adresse getOne(long idAdresse) { return service.getOne(idAdresse); }
    public List<Adresse> getAll() { return service.getAll(); }
}
