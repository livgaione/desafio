package br.com.it.product.infrastructure;

import br.com.it.product.domain.request.OrderRequest;
import br.com.it.product.service.MessagingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQ {

    @Autowired
    private MessagingService service;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void recive(@Payload OrderRequest request) {
        service.processOrder(request);
    }

}