package br.com.it.product.service;

import br.com.it.product.domain.Client;
import br.com.it.product.domain.Order;
import br.com.it.product.domain.mapping.OrderMapping;
import br.com.it.product.repository.OrderRepository;
import br.com.it.product.domain.response.Amount;
import br.com.it.product.domain.response.OrderClients;
import br.com.it.product.domain.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderMapping mapper;

    public OrderResponse getOrderById(Long id) {
        Order orderModel = repository.findById(id).orElseThrow();
        OrderResponse response = mapper.transformation(orderModel);
        return response;
    }

    public Amount getAmount(Long id) {
        Order orderModel = repository.findById(id).orElseThrow();
        BigDecimal amount = BigDecimal.valueOf(
                orderModel.getItems().stream()
                .mapToDouble(item ->
                        item.getQuantity() * item.getProductId().getPrice())
                .sum()).setScale(2, RoundingMode.CEILING);
        return Amount.builder()
                .order(id)
                .amount(amount)
                .build();
    }
    public List<Order> getOrdersByClient(Client client) {
        return repository.findAllByCliente(client);
    }

    public OrderClients getOrderByClient(Client client) {
        List<OrderResponse> response = new ArrayList<>();
        List<Order> orderByClients = getOrdersByClient(client);
        orderByClients.forEach(orders -> {
            OrderResponse order = mapper.transformation(orders);
            response.add(order);
        });
        return OrderClients.builder()
                .clientId(client.getClientId())
                .clientName(client.getClientName())
                .orders(response)
                .build();
    }
}