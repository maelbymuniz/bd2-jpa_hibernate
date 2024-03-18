package br.edu.ifpb.bd2.jpahibernate.services;

import br.edu.ifpb.bd2.jpahibernate.dtos.ProductDTO;
import br.edu.ifpb.bd2.jpahibernate.entities.Product;
import br.edu.ifpb.bd2.jpahibernate.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Optional<ProductDTO> create(ProductDTO request) {
        var product = new Product(request);
        repository.saveAndFlush(product);

        ProductDTO response =  new ProductDTO(product.getId(), product.getName(),
                product.getQuantity(), product.getPrice(), product.getDescription(), product.getCategory() , product.isAvailable());

        return Optional.of(response);
    }

    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();
        List<ProductDTO> responses = new ArrayList<>();

        for (Product product : products) {
            ProductDTO response = new ProductDTO(product);
            responses.add(response);
        }

        return responses;
    }

    public Optional<ProductDTO> findById(Long id) {
        Optional<Product> product = repository.findById(id);

        ProductDTO productDTO = new ProductDTO(product.get());

        return Optional.of(productDTO);
    }

    public Optional<ProductDTO> update(Long id, ProductDTO request) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            product.get().setName(request.name());
            product.get().setQuantity(request.quantity());
            product.get().setPrice(request.price());
            product.get().setDescription(request.description());
            product.get().setCategory(request.category());
            repository.saveAndFlush(product.get());

            ProductDTO productDTO = new ProductDTO(product.get());

            return Optional.of(productDTO);
        }
        return Optional.empty();
    }

    /**
     * Fazer 2 Deletes:
     * 1 - 'Hard' que remove a informação do BD
     * 2 - 'Lógico' que apenas desativa o objeto (caso na nossa aplicação necessitemos criar um histórico)
     */
    public boolean delete(Long id) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;

    }
    public boolean disable(Long id) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            product.get().setAvailable(false);
            repository.saveAndFlush(product.get());
            return true;
        }
        return false;
    }

}
