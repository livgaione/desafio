package br.com.it.product.domain.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderClients {

    private Long clientId;

    private String clientName;

    private List<OrderResponse> orders;

}