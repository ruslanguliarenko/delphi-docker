package com.udelphi.repository;

import java.util.Set;
import com.udelphi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from User as u " +
            " inner join u.orders as o " +
            " inner join OrderItem as oi on o.id = oi.order.id" +
            " inner join Product as p on p.id = oi.product.id" +
            " where u.id =:id")
    Set<Product> findAllByUserId(int id);
}
