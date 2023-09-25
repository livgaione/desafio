package br.com.it.product.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClientRequest {

    @NotNull
    @NotBlank
    private String name;

}