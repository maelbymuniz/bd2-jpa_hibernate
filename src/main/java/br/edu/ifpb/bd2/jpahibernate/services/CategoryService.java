package br.edu.ifpb.bd2.jpahibernate.services;

import br.edu.ifpb.bd2.jpahibernate.dtos.CategoryDTO;
import br.edu.ifpb.bd2.jpahibernate.dtos.ProductDTO;
import br.edu.ifpb.bd2.jpahibernate.entities.Category;
import br.edu.ifpb.bd2.jpahibernate.entities.Product;
import br.edu.ifpb.bd2.jpahibernate.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Optional<CategoryDTO> create(CategoryDTO request) {
        var product = new Category(request);
        repository.saveAndFlush(product);

        CategoryDTO response = new CategoryDTO(product.getId(), product.getName());

        return Optional.of(response);
    }

    public List<CategoryDTO> findAll() {
        List<Category> categories = repository.findAll();
        List<CategoryDTO> responses = new ArrayList<>();

        // Essa parte aqui, ainda tenho que entender melhor
        categories.forEach(category -> {
//            ProductDTO response = mapper.map(product, ProductDTO.class);
            CategoryDTO response = new CategoryDTO(category);
            responses.add(response);
        });

        return responses;
    }

    public Optional<CategoryDTO> findById(Long id) {
        Optional<Category> category = repository.findById(id);
        CategoryDTO categoryDTO = new CategoryDTO(category.get());
        return Optional.of(categoryDTO);
    }
}