package br.com.it.product.service;

import br.com.it.product.domain.Client;
import br.com.it.product.domain.Items;
import br.com.it.product.domain.Order;
import br.com.it.product.domain.Product;
import br.com.it.product.domain.request.ItemRequest;
import br.com.it.product.domain.request.OrderRequest;
import br.com.it.product.repository.ClientRepository;
import br.com.it.product.repository.ItemOrderRepository;
import br.com.it.product.repository.OrderRepository;
import br.com.it.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemOrderRepository itemOrderRepository;

    @Autowired
    private ProductRepository productRepository;

    public void processOrder(OrderRequest request) {
        Client client = getClient(request);
        Order order = save(request, client);
        saveItem(request, order);
    }

    private Client getClient(OrderRequest request) {
        return clientRepository.findById(request.getClientId()).orElseThrow();
    }

    private Order save(OrderRequest request, Client client) {
        return orderRepository.save(getOrder(request, client));
    }

    private void saveItem(OrderRequest request, Order order) {
        request.getItems().forEach(itemRequest -> {
            Items itemOrder = Items.builder()
                    .quantity((int) itemRequest.getQuantity())
                    .orderId(order)
                    .productId(getProduct(itemRequest))
                    .build();
            itemOrderRepository.save(itemOrder);
        });
    }

    private Order getOrder(OrderRequest request, Client client) {
        return Order.builder()
                .orderCode(request.getOrderId())
                .clientId(client)
                .build();
    }

    private Product getProduct(ItemRequest request) {
        return productRepository.findByName(request.getProduct()).orElseThrow();
    }
}
