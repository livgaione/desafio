package br.com.it.product.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class ItemRequest implements Serializable {

    @JsonProperty("product")
    private String product;

    @JsonProperty("quantity")
    private long quantity;

    @JsonProperty("price")
    private BigDecimal price;

}