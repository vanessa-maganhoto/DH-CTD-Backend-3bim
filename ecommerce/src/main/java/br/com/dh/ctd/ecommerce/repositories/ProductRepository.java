package br.com.dh.ctd.ecommerce.repositories;

import br.com.dh.ctd.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

    /*@Query("SELECT obj FROM Products obj JOIN FETCH obj.categories " +
            "WHERE obj IN :products")
    List<Products> buscarTodos(List<Products> products);*/

}
