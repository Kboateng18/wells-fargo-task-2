package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private List<Client> clients = new ArrayList<>();

    public List<Client> getAllClients() {
        return clients;
    }

    public Client getClientById(Long id) {
        return clients.stream()
                .filter(client -> client.getClientId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client createClient(Client client) {
        clients.add(client);
        return client;
    }

    public Client updateClient(Long id, Client updatedClient) {
        Client client = getClientById(id);
        client.setFirstName(updatedClient.getFirstName());
        client.setLastName(updatedClient.getLastName());
        client.setAddress(updatedClient.getAddress());
        client.setPhone(updatedClient.getPhone());
        client.setEmail(updatedClient.getEmail());
        client.setAdvisor(updatedClient.getAdvisor());
        return client;
    }

    public void deleteClient(Long id) {
        Client client = getClientById(id);
        clients.remove(client);
    }
}