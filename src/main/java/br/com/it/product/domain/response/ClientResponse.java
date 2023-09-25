package br.com.it.product.domain.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClientResponse {

    private Long clientId;

    private String clientName;

}