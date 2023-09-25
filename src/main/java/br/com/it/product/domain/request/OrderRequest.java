package br.com.it.product.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    @JsonProperty("orderId")
    private long OrderId;

    @JsonProperty("clientId")
    private long clientId;

    @JsonProperty("items")
    private List<ItemRequest> items;

}