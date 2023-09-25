package br.com.it.product.domain.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class QuantityOrders {

    private Long clientId;

    private String clientName;

    private Integer quantityOrders;
}
