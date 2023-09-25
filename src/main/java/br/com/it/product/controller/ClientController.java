package br.com.it.product.controller;

import br.com.it.product.domain.request.ClientRequest;
import br.com.it.product.domain.response.ClientResponse;
import br.com.it.product.domain.response.QuantityOrders;
import br.com.it.product.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}/orders")
    public QuantityOrders getQuantityOrders(@PathVariable("id") Long id) {
        return service.getQuantityOrders(id);
    }

    @PostMapping
    public ClientResponse post(@RequestBody @Valid ClientRequest request) {
        return service.save(request);
    }

}
