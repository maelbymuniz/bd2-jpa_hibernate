package br.edu.ifpb.bd2.jpahibernate.services;

import br.edu.ifpb.bd2.jpahibernate.dtos.ProductDTO;
import br.edu.ifpb.bd2.jpahibernate.entities.Product;
import br.edu.ifpb.bd2.jpahibernate.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Optional<ProductDTO> create(ProductDTO productDTO) {
        var product = new Product(productDTO);
        repository.saveAndFlush(product);

        ProductDTO response =  new ProductDTO(product.getId(), product.getName(),
                product.getQuantity(), product.getPrice(), product.getDescription(), product.isAvailable());

        return Optional.of(response);
    }

}
