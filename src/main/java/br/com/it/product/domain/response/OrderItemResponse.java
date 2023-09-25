package br.com.it.product.domain.response;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderItemResponse {

    private String product;

    private BigDecimal price;

    private Integer quantity;

}