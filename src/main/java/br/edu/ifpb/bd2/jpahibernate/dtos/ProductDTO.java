package br.edu.ifpb.bd2.jpahibernate.dtos;

import br.edu.ifpb.bd2.jpahibernate.entities.Category;
import br.edu.ifpb.bd2.jpahibernate.entities.Product;

public record ProductDTO(Long id, String name, Integer quantity, Double price, String description, Category category, boolean available) {
    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getQuantity(), product.getPrice(), product.getDescription(), product.getCategory(), product.isAvailable());
    }
}
