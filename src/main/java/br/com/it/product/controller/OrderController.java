package br.com.it.product.controller;

import br.com.it.product.domain.Client;
import br.com.it.product.domain.response.Amount;
import br.com.it.product.domain.response.OrderClients;
import br.com.it.product.domain.response.OrderResponse;
import br.com.it.product.service.ClientService;
import br.com.it.product.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public OrderResponse getOrderById(@PathVariable("id") Long id) {
        return service.getOrderById(id);
    }

    @GetMapping(value = "/{clientId}/clients")
    public OrderClients getOrderByClient(@PathVariable("clientId") Long clientId) {
        Client client = clientService.getClientById(clientId);
        return service.getOrderByClient(client);
    }

    @GetMapping(value = "/{id}/amount")
    public Amount getAmountById(@PathVariable("id") Long id) {
        return service.getAmount(id);
    }
}
