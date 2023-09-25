package br.com.it.product.repository;

import br.com.it.product.domain.Client;
import br.com.it.product.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByCliente(Client clienteModel);

}
