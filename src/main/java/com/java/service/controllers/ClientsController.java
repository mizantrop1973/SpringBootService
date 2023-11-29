package com.java.service.controllers;
import com.java.service.forms.ClientForm;
import com.java.service.models.Client;
import com.java.service.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Controller
public class ClientsController {

    private String myProperty;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DataSource dataSource;

    @GetMapping("/clients")
    @Transactional
    public String getClientsPage(
            ModelMap model,
            @RequestParam(name = "client_id", required = false) Long clientId,
            @RequestParam(value = "client_name", required = false ) String clientName){

        List<Client> clients = clientId == null ?
                clientName == null ?
                        clientRepository.findAll() :
                        clientRepository.findAllByClientName(clientName) :
                clientRepository.findById(clientId).isPresent() ?
                        clientName == null ?
                                Collections.singletonList(clientRepository.findById(clientId).get()) :
                                clientRepository.findAllByClientIdAndClientName(clientId, clientName):
                        Collections.emptyList()
                ;
        model.addAttribute("clientsFromServer", clients);
        for (Client client : clients) {
            client.getPhones().toString();
            client.getEmails().toString();
        }


        return "clients";
    }
    @PostMapping("/clients")
    public String addClient (ClientForm clientForm) {
       System.out.println("Registration");
       Client newClient = Client.from(clientForm);
       clientRepository.save(newClient);
       return "redirect:/clients";
    }

}
