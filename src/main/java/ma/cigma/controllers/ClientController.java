package ma.cigma.controllers;

import ma.cigma.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String url;

    @GetMapping(value = {"/", "/clients"})
    public String getAll(Model model, @ModelAttribute("client") Client c){
        List<Client> clients = restTemplate.getForObject(url+"/client/all", List.class);
        model.addAttribute("clients", clients);
        model.addAttribute("client", c == null ? new Client() : c);
        return "index-client";
    }

    @RequestMapping(value = "/add-client", method = RequestMethod.POST)
    public String addClient(Model model, @ModelAttribute("client") Client client){
        restTemplate.postForObject(url+"/client/add", client, Client.class);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/edit-client", method = RequestMethod.POST)
    public String editClient(Model model, @ModelAttribute("client") Client client){
        restTemplate.put(url+"/client/update", client, Client.class);
        return "redirect:/clients";
    }

    @GetMapping(value = "/delete-client/{id}")
    public String delete(@PathVariable long id){
        restTemplate.delete(url+"/client/"+id);
        return "redirect:/clients";
    }

    @GetMapping(value = "/show-client/{id}")
    public String show(@PathVariable long id, RedirectAttributes ra){
        Client client = restTemplate.getForObject(url+"/client/"+id, Client.class);
        ra.addFlashAttribute("client", client);
        return "redirect:/clients";
    }
}
