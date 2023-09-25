package br.com.it.product.domain.mapping;

import br.com.it.product.domain.Order;
import br.com.it.product.domain.response.OrderResponse;
import org.mapstruct.*;

public abstract class OrderMapping {

    @Mapping(target = "item")
    public abstract OrderResponse transformation(Order order);

}