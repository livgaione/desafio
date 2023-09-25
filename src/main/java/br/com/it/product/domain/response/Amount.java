package br.com.it.product.domain.response;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Amount {

    private Long order;

    private BigDecimal amount;

}