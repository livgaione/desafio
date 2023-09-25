package br.com.it.product.domain.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {

    private Long orderId;

    private Long clientId;

    private List<OrderItemResponse> items;

}