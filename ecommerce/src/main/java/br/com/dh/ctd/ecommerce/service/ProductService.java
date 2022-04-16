package br.com.dh.ctd.ecommerce.service;

import br.com.dh.ctd.ecommerce.dto.ProductDto;
import br.com.dh.ctd.ecommerce.model.Products;
import br.com.dh.ctd.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<ProductDto> buscarTodos(PageRequest pageRequest) {
        Page<Products> list = productRepository.findAll(pageRequest);
        return list.map(x -> new ProductDto(x));
    }
    @Transactional(readOnly = true)
    public ProductDto findById(Integer id) {
        Optional<Products> obj = productRepository.findById(id);
        Products entidade = obj.get();
        return new ProductDto((entidade));
    }

}
