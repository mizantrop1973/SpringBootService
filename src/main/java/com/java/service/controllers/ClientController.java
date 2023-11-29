package com.java.service.controllers;
import com.java.service.forms.ClientForm;
import com.java.service.forms.ContactsForm;
import com.java.service.models.Client;
import com.java.service.models.Email;
import com.java.service.models.Phone;
import com.java.service.repositories.ClientRepository;
import com.java.service.repositories.EmailRepository;
import com.java.service.repositories.PhoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Controller
public class ClientController {

    private String myProperty;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private EmailRepository emailRepository;

    private Long id;

    @GetMapping("/client")
    @Transactional
    public String getClientPage(
            ModelMap model,
            @RequestParam(name = "client_id", required = false) Long clientId,
            @RequestParam(value = "client_name", required = false ) String clientName){

        id = clientId;

        List<Client> client = clientId == null ?
                clientName == null ?
                        clientRepository.findAll() :
                        clientRepository.findAllByClientName(clientName) :
                clientRepository.findById(clientId).isPresent() ?
                        clientName == null ?
                                Collections.singletonList(clientRepository.findById(clientId).get()) :
                                clientRepository.findAllByClientIdAndClientName(clientId, clientName):
                        Collections.emptyList()
                ;
        model.addAttribute("clientFromServer", client);
        for (Client cl : client) {
            cl.getPhones().toString();
            cl.getEmails().toString();

        }

        return "client";
    }
    @PostMapping("/client")
    public String addContacts (ContactsForm contactsForm, Client client) {
        System.out.println("Adding contacts");
        if(clientRepository.findById(id).isPresent()) {
            Client cl = clientRepository.findById(id).get();
            Phone newPhone = Phone.fromContactsPhone(contactsForm, cl);
            phoneRepository.save(newPhone);
            Email newEmail = Email.fromContactsEmail(contactsForm, cl);
            emailRepository.save(newEmail);
        }

        return "redirect:/clients";
    }

}
