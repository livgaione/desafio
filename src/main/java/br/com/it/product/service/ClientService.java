package br.com.it.product.service;

import br.com.it.product.domain.Client;
import br.com.it.product.repository.ClientRepository;
import br.com.it.product.domain.request.ClientRequest;
import br.com.it.product.domain.response.ClientResponse;
import br.com.it.product.domain.response.QuantityOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private OrderService service;

    public Client getClientById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public QuantityOrders getQuantityOrders(Long id) {
        Client client = repository.findById(id).orElseThrow();
        int quantityOrder = service.getOrdersByClient(client).size();
        return QuantityOrders.builder()
                .clientId(id)
                .clientName(client.getClientName())
                .quantityOrders(quantityOrder)
                .build();
    }

    public ClientResponse save(ClientRequest req) {
        Client client = repository.save(Client.builder()
                .clientName(req.getName())
                .build());
        return ClientResponse.builder()
                .clientId(client.getClientId())
                .clientName(client.getClientName())
                .build();
    }
}