package br.com.it.product.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "orderId")
    private Long orderCode;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client clientId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Items> items;

}